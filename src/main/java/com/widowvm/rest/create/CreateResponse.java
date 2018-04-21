package com.widowvm.rest.create;

public class CreateResponse {
    private String name;

    public CreateResponse(String name){
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
