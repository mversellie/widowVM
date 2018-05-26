package com.widowvm.rest.delete;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.widowvm.rest.interfaces.Request;

public class DeleteRequest extends Request {

    @JsonCreator
    public DeleteRequest(@JsonProperty("name") String name){
        super(name);
    }
}
