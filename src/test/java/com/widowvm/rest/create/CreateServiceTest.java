package com.widowvm.rest.create;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateServiceTest {

    @Test
    public void isVmCorrectlyCreated() {
        CreateResponse correctResponse = new CreateResponse("myVm",200);
        CreateRequest testRequest = new CreateRequest("myVm",1,2000,1);
        CreateResponse testResponse = CreateService.createVm(testRequest);
        assertEquals(correctResponse.getname(),testResponse.getname());
        assertEquals(correctResponse.getStatus(),testResponse.getStatus());
    }
}