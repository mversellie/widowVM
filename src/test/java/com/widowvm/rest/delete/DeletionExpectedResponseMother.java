package com.widowvm.rest.delete;

public class DeletionExpectedResponseMother {

    public static String stringifiedResponse(){
        return "{\"name\":\"deleteVm\" ," +
                "\"status\":200 ," +
                "\"deletionStatus\":true}";
    }

    public static DeleteResponse generateDeletedResponse(){
        DeleteResponse response = new DeleteResponse("deleteVm",200,true);
        return  response;
    }
}
