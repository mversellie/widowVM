package com.widowvm.widowvm.status;

public class StatusExpectedResponseMother {

    public static String stringifiedCorrectResponse(){
        return "{\"name\":\"statusVm\"," +
                "\"status\":true," +
                "\"vmFound\":true," +
                "\"attributes\": {" +
                        "\"memory\":512 ," +
                        "\"isRunning\":true ," +
                        "\"vCpus\":1" +
                        "}}";
    }

    public static StatusResponse generateExpectedCorrectResponse(){
        StatusResponse expectedResponse = new StatusResponse();
        expectedResponse.setMemory(512);
        expectedResponse.setvCpus(1);
        expectedResponse.setName("statusVm");
        expectedResponse.setRunning(true);
        expectedResponse.setSuccess(true);
        return  expectedResponse;
    }

    public static StatusResponse generateInvalidResponse(){
        StatusResponse response = new StatusResponse();
        response.setName("notAVm");
        return response;
    }


}
