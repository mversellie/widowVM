package com.widowvm.rest.interfaces;

public class Request {
    protected final String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
