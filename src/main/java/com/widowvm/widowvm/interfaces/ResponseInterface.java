package com.widowvm.widowvm.interfaces;

public class ResponseInterface {
    protected String name;
    protected boolean success;

    public ResponseInterface(String name, boolean status) {
        this.name = name;
        this.success = status;
    }

    public ResponseInterface(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
