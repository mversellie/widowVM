package com.widowvm.widowvm;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.widowvm.widowvm.create.CreateRequest;
import com.widowvm.widowvm.create.CreateResponse;
import com.widowvm.widowvm.delete.DeleteRequest;
import com.widowvm.widowvm.delete.DeleteResponse;
import com.widowvm.widowvm.delete.DeleteService;
import com.widowvm.widowvm.list.ListResponse;
import com.widowvm.widowvm.status.StatusExpectedResponseMother;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WidowVmControllerIntegrationTest {

    private MockMvc mockMvc;

    private final String BASE_URL = "http://localhost:9050";
    private final String CREATE_ENDPOINT = BASE_URL + "/kvm/create";
    private final String DELETE_ENDPOINT = BASE_URL + "/kvm/delete";
    private final String LIST_ENDPOINT = BASE_URL + "/kvm/list";
    private ObjectMapper mapper;


    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private DeleteService deleteService;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        mapper = new ObjectMapper();

    }


    @Test
    public void givenWac_whenServletContext_thenItProvidesWidowVmController() {


        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("widowVmController"));
    }

    @Test
    public void sendValidRequestToCreateEndpoint() throws Exception {
        String machineName = "skjd";

        CreateResponse expectedResponse = new CreateResponse(machineName,true);

        CreateRequest testRequestBeforeCreate = new CreateRequest(machineName,5,512,1);
        testRequestBeforeCreate.getAdditionalOptions().put("rootPassword","rootPassword!");
        testRequestBeforeCreate.getAdditionalOptions().put("encryptRootPassword",true);
        testRequestBeforeCreate.getAdditionalOptions().put("sudoUser","testuser");
        testRequestBeforeCreate.getAdditionalOptions().put("sudoPassword", "sudoPass");
        testRequestBeforeCreate.getAdditionalOptions().put("fullName","aFullName");

        this.mockMvc.perform(post(CREATE_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(testRequestBeforeCreate)))
                .andExpect((content().json(mapper.writeValueAsString(expectedResponse))))
                .andExpect(status().is2xxSuccessful());

        deleteService.deleteVm(new DeleteRequest(machineName));
    }


    @Test
    public void sendInvalidRequestToCreateEndpoint() throws Exception {
        CreateRequest invalidRequest = new CreateRequest();

        CreateResponse expectedResponse = new CreateResponse("",false);

        this.mockMvc.perform(post(CREATE_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(invalidRequest)))
                .andExpect((content().json(mapper.writeValueAsString(expectedResponse))))
                .andExpect((status().is4xxClientError()));
    }

    @Test
    public void sendValidDeleteRequestToDeleteEndpoint() throws Exception {
        String deleteMachineName = "deleteVm2";

        DeleteRequest actualRequest = new DeleteRequest(deleteMachineName);

        DeleteResponse expectedResponse = new DeleteResponse(deleteMachineName,true);

        this.mockMvc.perform(post(DELETE_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(actualRequest)))
                .andExpect((content().json(mapper.writeValueAsString(expectedResponse))))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void sendInvalidDeleteRequestToDeleteEndpoint() throws Exception {
        String deleteMachineName = "vmNotValid";

        DeleteRequest actualRequest = new DeleteRequest(deleteMachineName);

        DeleteResponse expectedResponse = new DeleteResponse(deleteMachineName,false);

        this.mockMvc.perform(post(DELETE_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(actualRequest)))
                .andExpect((content().json(mapper.writeValueAsString(expectedResponse))))
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void sendValidStatusRequestToStatusEndpoint() throws Exception {
        String statusVm = "statusVm";
        String statusVmUrl = BASE_URL + "/kvm/" + statusVm + "/status";

        this.mockMvc.perform(get(statusVmUrl))
                .andExpect((content().json(mapper.writeValueAsString(StatusExpectedResponseMother.generateExpectedCorrectResponse()))))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void sendInvalidStatusRequestToStatusEndpoint() throws Exception {
        String statusVm = "notAVm";
        String statusVmUrl = BASE_URL + "/kvm/" + statusVm + "/status";

        this.mockMvc.perform(get(statusVmUrl))
                .andExpect((content().json(mapper.writeValueAsString(StatusExpectedResponseMother.generateInvalidResponse()))))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void listEndpointTest() throws Exception  {
        ListResponse actualResponse = mapper.readValue(
            this.mockMvc.perform(get(LIST_ENDPOINT))
                    .andExpect(status().is2xxSuccessful())
                    .andReturn().getResponse().getContentAsString(),
                ListResponse.class);
        Assert.assertTrue(actualResponse.getNames().contains("listVm1"));
        Assert.assertTrue(actualResponse.getNames().contains("statusVm"));
    }
}
