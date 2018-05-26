package com.widowvm.rest.create;

import com.widowvm.rest.interfaces.Response;

public class CreateResponse extends Response {
    public CreateResponse(String name,Integer status ) {
        super(name,status);
        this.status = status;
    }

}
