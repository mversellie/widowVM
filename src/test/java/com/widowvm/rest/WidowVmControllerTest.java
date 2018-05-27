package com.widowvm.rest;

import com.widowvm.rest.create.CreateRequest;
import com.widowvm.rest.create.CreateResponse;
import com.widowvm.rest.delete.DeleteRequest;
import com.widowvm.rest.delete.DeleteResponse;
import com.widowvm.rest.delete.DeletionExpectedResponseMother;
import com.widowvm.rest.list.ListExpectedResponseMother;
import com.widowvm.rest.list.ListResponse;
import com.widowvm.rest.status.StatusExpectedResponseMother;
import com.widowvm.rest.status.StatusRequest;
import com.widowvm.rest.status.StatusResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WidowVmControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private WidowVmController widowVmController;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void createVmWithValidRequest() throws Exception {
        CreateResponse expectedResponse = new CreateResponse("myMadeVm",200);
        given(widowVmController.createVm(any(CreateRequest.class))).willReturn(expectedResponse);
            mockMvc.perform(post("/create")
                    .contentType(APPLICATION_JSON)
                    .content("{\"size\":2000,\"memory\":2048,\"name\":\"myMadeVm\",\"vCpus\":1}"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(content().json("{\"name\":\"myMadeVm\",\"status\":200}"));
    }

    @Test
    public void createVmWithInvalidRequest() throws Exception {
        CreateResponse expectedResponse = new CreateResponse("myMadeVm",400);
        given(widowVmController.createVm(any(CreateRequest.class))).willReturn(expectedResponse);
        mockMvc.perform(post("/create")
                .contentType(APPLICATION_JSON)
                .content("{\"memory\":2048,\"name\":\"myMadeVm\",\"vCpus\":1}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("{\"name\":\"myMadeVm\",\"status\":400}"));
    }

    @Test
    public void statusVmWithValidRequest() throws Exception{
        StatusResponse expectedResponse = StatusExpectedResponseMother.generateExpectedCorrectResponse();
        given(widowVmController.getVmStatus(any(StatusRequest.class))).willReturn(expectedResponse);
        mockMvc.perform(post("/status")
                .contentType(APPLICATION_JSON)
                .content("{\"name\":\"status_test\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(StatusExpectedResponseMother.stringifiedCorrectResponse()));
    }

    @Test
    public void deleteVmWithValidRequest() throws Exception{
        DeleteResponse deletedResponse = DeletionExpectedResponseMother.generateDeletedResponse();
        given(widowVmController.deleteVm(any(DeleteRequest.class))).willReturn(deletedResponse);
        mockMvc.perform(post("/delete")
                .contentType(APPLICATION_JSON)
                .content("{\"name\":\"deleteVm\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(DeletionExpectedResponseMother.stringifiedResponse()));
    }

    @Test
    public void listVm() throws Exception{
        ListResponse listResponse = ListExpectedResponseMother.expectedResponse();
        given(widowVmController.listVms()).willReturn(listResponse);
        mockMvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(ListExpectedResponseMother.expectedResponseAsString));
    }
}