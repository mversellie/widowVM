package com.widowvm.widowvm.list;

import java.util.ArrayList;

public class ListExpectedResponseMother {
    public static final String expectedResponseAsString =
            "{\"names\":[\"happyVm\",\"sadVm\"], \"status\":true}";

    public static ListResponse expectedResponse(){
        ArrayList<String> names = new ArrayList();
        names.add("happyVm");
        names.add("sadVm");


        return new ListResponse(names,true);
    }

}
