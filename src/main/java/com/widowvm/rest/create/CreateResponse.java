package com.widowvm.rest.create;

public class CreateResponse {
    private String name;
    private Integer status;

    public CreateResponse() {

    }

    public CreateResponse(String name,Integer status ) {
        this.name = name;
        this.status = status;
    }

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
