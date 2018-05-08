package com.widowvm.rest.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusServiceTest {

    StatusResponse correctResponse;
    StatusRequest testRequest;
    StatusResponse testResponse;

    @Before
    public void setUp() throws Exception {
        correctResponse = StatusExpectedResponseMother.generateExpectedResponse();
        testRequest = new StatusRequest("status_test");
        testResponse = StatusService.getVmStatus(testRequest);
    }

    @Test
    public void isResponseNotNull() {
        assert(testResponse != null);
    }

    @Test
    public void isResponseValid(){
        assert(testResponse.getMemory() != null);
        assert(testResponse.getName().equals(correctResponse.getName()));
        assert(testResponse.getvCpus().equals(correctResponse.getvCpus()));
        assert(testResponse.isRunning() == correctResponse.isRunning());
    }


}