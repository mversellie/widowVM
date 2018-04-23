package com.widowvm.rest.create;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreateServiceTest {

    @Test
    public void isVmCorrectlyCreated() {
        CreateResponse correctResponse = new CreateResponse("myVm",200);
        CreateRequest testRequest = new CreateRequest("myVm",1,1024,1);
        CreateResponse testResponse = CreateService.createVm(testRequest);
        assertEquals(correctResponse.getname(),testResponse.getname());
        assertEquals(correctResponse.getStatus(),correctResponse.getStatus());
    }
}