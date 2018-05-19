package com.widowvm.rest.create;

import com.widowvm.rest.interfaces.Response;

public class CreateResponse extends Response {
    private Integer status;


    public CreateResponse(String name,Integer status ) {
        super(name);
        this.status = status;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
