package com.widowvm.rest.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusServiceTest {

    StatusResponse expectedResponse;
    StatusRequest testRequest;
    StatusResponse testResponse;


    @Test
    public void isResponseValid(){
        expectedResponse = StatusExpectedResponseMother.generateExpectedCorrectResponse();
        testRequest = new StatusRequest("statusVm");
        testResponse = StatusService.getVmStatus(testRequest);
        assertNotEquals(null, testResponse.getMemory());
        assertEquals(expectedResponse.getName(), testResponse.getName());
        assertEquals(expectedResponse.getvCpus(), testResponse.getvCpus());
        assertEquals(expectedResponse.isRunning(), testResponse.isRunning());
        assertTrue(testResponse.isVmFound());
    }

    @Test
    public void isResponseinValidOnInvalidRequest() {
        expectedResponse = StatusExpectedResponseMother.generateInvalidResponse();
        StatusRequest badRequest = new StatusRequest("notAVm");
        testResponse = StatusService.getVmStatus(badRequest);
        assertEquals(badRequest.getName(), testResponse.getName());
        assertEquals(0, testResponse.getAttributes().keySet().size());
        assertEquals((Integer)400,testResponse.getStatus());
        assertFalse(testResponse.isVmFound());
    }
}