package com.widowvm.rest.delete;

import com.widowvm.rest.interfaces.ResponseInterface;

public class DeleteResponse extends ResponseInterface {
    private boolean deletionStatus;

    public DeleteResponse(String name, Integer status, boolean deletionStatus) {
        super(name, status);
        this.deletionStatus = deletionStatus;
    }

    public DeleteResponse(String name, boolean deletionStatus) {
        super(name);
        this.deletionStatus = deletionStatus;
    }

    public DeleteResponse(String name){
        super(name);
    }

    public boolean isDeletionStatus() {
        return deletionStatus;
    }

    public void setDeletionStatus(boolean deletionStatus) {
        this.deletionStatus = deletionStatus;
    }
}
