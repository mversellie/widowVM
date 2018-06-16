package com.widowvm.rest.interfaces;

public class RequestInterface {
    protected final String name;

    public RequestInterface(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
