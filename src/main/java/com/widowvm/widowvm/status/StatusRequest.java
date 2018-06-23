package com.widowvm.widowvm.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.widowvm.widowvm.interfaces.RequestInterface;

public class StatusRequest extends RequestInterface {

    @JsonCreator
    public StatusRequest(@JsonProperty("name") String name){
        super(name);
    }

}
