package com.widowvm.rest.create;

import com.widowvm.rest.interfaces.ResponseInterface;

public class CreateResponse extends ResponseInterface {
    public CreateResponse(String name, Integer status ) {
        super(name,status);
        this.status = status;
    }

}
