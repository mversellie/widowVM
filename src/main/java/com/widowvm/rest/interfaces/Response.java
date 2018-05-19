package com.widowvm.rest.interfaces;

public class Response {
    protected String name;

    public Response(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
