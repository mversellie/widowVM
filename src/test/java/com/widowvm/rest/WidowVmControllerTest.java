package com.widowvm.rest;

import com.widowvm.rest.create.CreateRequest;
import com.widowvm.rest.create.CreateResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
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
        CreateResponse expectedResponse = new CreateResponse("myVm",200);
        given(widowVmController.createResponse(any(CreateRequest.class))).willReturn(expectedResponse);
            mockMvc.perform(post("/create")
                    .contentType(APPLICATION_JSON)
                    .content("{\"size\":2000,\"memory\":2048,\"name\":\"myVm\",\"vCpus\":1}"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(content().json("{\"name\":\"myVm\",\"status\":200}"));
    }

    @Test
    public void createVmWithInvalidRequest() throws Exception {
        CreateResponse expectedResponse = new CreateResponse("myVm",400);
        given(widowVmController.createResponse(any(CreateRequest.class))).willReturn(expectedResponse);
        mockMvc.perform(post("/create")
                .contentType(APPLICATION_JSON)
                .content("{\"memory\":2048,\"name\":\"myVm\",\"vCpus\":1}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("{\"name\":\"myVm\",\"status\":400}"));
    }
}