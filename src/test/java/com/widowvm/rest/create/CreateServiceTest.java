package com.widowvm.rest.create;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;




@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateServiceTest {

    @Autowired
    private CreateService createService;

    @Test
    public void isVmCorrectlyCreated() {
        CreateResponse correctResponse = new CreateResponse("createVm",200);
        CreateRequest testRequestBeforeCreate = new CreateRequest("createVm",10,500,1);
        CreateResponse testResponse = createService.createVm(testRequestBeforeCreate);
        assertEquals(correctResponse.getName(),testResponse.getName());
        assertEquals(correctResponse.getStatus(),testResponse.getStatus());


        //should fail as after the
        CreateResponse testResponseAfterCreation = createService.createVm(testRequestBeforeCreate);
        assertEquals(400,testResponseAfterCreation.getStatus().intValue());
    }


}