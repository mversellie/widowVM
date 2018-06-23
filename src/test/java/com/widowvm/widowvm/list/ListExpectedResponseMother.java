package com.widowvm.widowvm.list;

import java.util.ArrayList;

public class ListExpectedResponseMother {
    public static final String expectedResponseAsString =
            "{\"names\":[\"happyVm\",\"sadVm\"], \"status\":200}";

    public static ListResponse expectedResponse(){
        ArrayList<String> names = new ArrayList();
        names.add("happyVm");
        names.add("sadVm");


        return new ListResponse(names,200);
    }

}
