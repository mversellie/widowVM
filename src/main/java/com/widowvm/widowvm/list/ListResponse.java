package com.widowvm.widowvm.list;

import java.util.List;

public class ListResponse {
    private List<String> names;
    private boolean success =  true;

    public ListResponse() {
    }

    public ListResponse(boolean success) {
        this.success = success;
    }

    public ListResponse(List<String> names){
        this.names = names;
    }

    public ListResponse(List<String> names, Boolean success) {
        this.names = names;
        this.success = success;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
