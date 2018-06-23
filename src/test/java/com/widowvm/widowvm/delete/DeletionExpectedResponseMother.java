package com.widowvm.widowvm.delete;

public class DeletionExpectedResponseMother {

    public static String stringifiedResponse(){
        return "{\"name\":\"deleteVm\" ," +
                "\"status\":true ," +
                "\"deletionStatus\":true}";
    }

    public static DeleteResponse generateDeletedResponse(){
        DeleteResponse response = new DeleteResponse("deleteVm",true);
        return  response;
    }
}
