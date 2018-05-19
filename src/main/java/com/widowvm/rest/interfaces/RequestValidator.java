package com.widowvm.rest.interfaces;

public class RequestValidator {
    protected Request request;

    protected RequestValidator(Request request) {
        this.request = request;
    }

    protected boolean validateNameLength(){
        return request.getName().length() != 0;
    }

}
