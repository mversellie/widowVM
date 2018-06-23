package com.widowvm.widowvm.delete;

import com.widowvm.widowvm.interfaces.ResponseInterface;

public class DeleteResponse extends ResponseInterface {

    public DeleteResponse(String name, boolean status) {
        super(name, status);
    }


    public DeleteResponse(String name){
        super(name);
    }

}
