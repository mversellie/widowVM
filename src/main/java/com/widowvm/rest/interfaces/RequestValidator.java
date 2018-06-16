package com.widowvm.rest.interfaces;

public class RequestValidator {
    protected RequestInterface requestInterface;

    protected RequestValidator(RequestInterface requestInterface) {
        this.requestInterface = requestInterface;
    }

    protected boolean validateNameLength(){
        return requestInterface.getName().length() != 0;
    }

    public boolean isRequestValid(){
        return false;
    }

}
