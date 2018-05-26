package com.widowvm.rest.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.widowvm.rest.interfaces.Request;

public class StatusRequest extends Request{

    @JsonCreator
    public StatusRequest(@JsonProperty("name") String name){
        super(name);
    }

}
