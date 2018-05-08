package com.widowvm.rest.status;

public class StatusRequest {
    private String name;

    public StatusRequest(String name){
        this.name = name;
    }

    public StatusRequest(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
