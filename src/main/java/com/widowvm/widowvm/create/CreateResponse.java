package com.widowvm.widowvm.create;

import com.widowvm.widowvm.interfaces.ResponseInterface;

public class CreateResponse extends ResponseInterface {
    public CreateResponse(String name, Boolean status ) {
        super(name,status);
    }

}
