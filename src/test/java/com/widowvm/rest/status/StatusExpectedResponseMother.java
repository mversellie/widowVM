package com.widowvm.rest.status;

public class StatusExpectedResponseMother {

    public static String stringifiedResponse(){
        return "{\"memory\":2040 ," +
                "\"running\":true ," +
                "\"name\":\"status_test\" ," +
                "\"vCpus\":1}";
    }

    public static StatusResponse generateExpectedResponse(){
        StatusResponse expectedResponse = new StatusResponse();
        expectedResponse.setMemory(2040);
        expectedResponse.setvCpus(1);
        expectedResponse.setName("status_test");
        expectedResponse.setRunning(true);
        return  expectedResponse;
    }




}
