package com.widowvm.rest.status;

public class StatusExpectedResponseMother {

    public static String stringifiedCorrectResponse(){
        return "{\"name\":\"statusVm\"," +
                "\"status\":200," +
                "\"vmFound\":true," +
                "\"attributes\": {" +
                        "\"memory\":500 ," +
                        "\"isRunning\":true ," +
                        "\"vCpus\":1" +
                        "}}";
    }

    public static StatusResponse generateExpectedCorrectResponse(){
        StatusResponse expectedResponse = new StatusResponse();
        expectedResponse.setMemory(500);
        expectedResponse.setvCpus(1);
        expectedResponse.setName("statusVm");
        expectedResponse.setRunning(true);
        expectedResponse.setVmFound(true);
        expectedResponse.setStatus(200);
        return  expectedResponse;
    }

    public static StatusResponse generateInvalidResponse(){
        StatusResponse response = new StatusResponse();
        response.setName("notAVm");
        return response;
    }


}
