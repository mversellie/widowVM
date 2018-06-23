package com.widowvm.widowvm.create;

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
        CreateResponse correctResponse = new CreateResponse("createVm",true);
        CreateRequest testRequestBeforeCreate = new CreateRequest("createVm",10,500,1);
        testRequestBeforeCreate.getAdditionalOptions().put("rootPassword","rootPassword!");
        testRequestBeforeCreate.getAdditionalOptions().put("encryptRootPassword",true);
        testRequestBeforeCreate.getAdditionalOptions().put("sudoUser","testuser");
        testRequestBeforeCreate.getAdditionalOptions().put("sudoPassword", "sudoPass");
        testRequestBeforeCreate.getAdditionalOptions().put("fullName","aFullName");


        CreateResponse testResponse = createService.createVm(testRequestBeforeCreate);
        assertEquals(correctResponse.getName(),testResponse.getName());
        assertEquals(correctResponse.isSuccess(),testResponse.isSuccess());


        //should fail as after the
        CreateResponse testResponseAfterCreation = createService.createVm(testRequestBeforeCreate);
        assertEquals(false,testResponseAfterCreation.isSuccess());
    }


}