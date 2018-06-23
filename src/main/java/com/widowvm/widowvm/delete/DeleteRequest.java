package com.widowvm.widowvm.delete;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.widowvm.widowvm.interfaces.RequestInterface;

public class DeleteRequest extends RequestInterface {

    @JsonCreator
    public DeleteRequest(@JsonProperty("name") String name){
        super(name);
    }
}
