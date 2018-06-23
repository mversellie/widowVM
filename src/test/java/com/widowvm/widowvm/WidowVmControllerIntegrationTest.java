package com.widowvm.widowvm;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.widowvm.widowvm.create.CreateRequest;
import com.widowvm.widowvm.create.CreateResponse;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WidowVmControllerIntegrationTest {

    private MockMvc mockMvc;

    private final String BASE_URL = "http://localhost:9050";
    private final String CREATE_ENDPOINT = BASE_URL + "/kvm/create";


    @Autowired
    private WebApplicationContext wac;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

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
        ObjectMapper mapper = new ObjectMapper();

        String machineName = "skjd";

        CreateResponse expectedResponse = new CreateResponse("skjd",true);

        CreateRequest testRequestBeforeCreate = new CreateRequest("skjd",5,500,1);
        testRequestBeforeCreate.getAdditionalOptions().put("rootPassword","rootPassword!");
        testRequestBeforeCreate.getAdditionalOptions().put("encryptRootPassword",true);
        testRequestBeforeCreate.getAdditionalOptions().put("sudoUser","testuser");
        testRequestBeforeCreate.getAdditionalOptions().put("sudoPassword", "sudoPass");
        testRequestBeforeCreate.getAdditionalOptions().put("fullName","aFullName");

        System.out.println(mapper.writeValueAsString(testRequestBeforeCreate));


        this.mockMvc.perform(post(CREATE_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(testRequestBeforeCreate)))
                .andExpect((content().json(mapper.writeValueAsString(expectedResponse))))
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void sendInvalidRequestToCreateEndpoint() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        CreateRequest invalidRequest = new CreateRequest();

        CreateResponse expectedResponse = new CreateResponse("",false);

        this.mockMvc.perform(post(CREATE_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(invalidRequest)))
                .andExpect((content().json(mapper.writeValueAsString(expectedResponse))));
    }
}
