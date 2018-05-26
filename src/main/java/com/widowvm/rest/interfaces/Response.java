package com.widowvm.rest.interfaces;

public class Response {
    protected String name;
    protected Integer status;

    public Response(String name,Integer status) {
        this.name = name;
        this.status = status;
    }

    public Response(String name){
        this.name = name;
    }

    public String getName() {
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
