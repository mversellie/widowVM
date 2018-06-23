package com.widowvm.widowvm.list;

import java.util.ArrayList;

public class ListResponse {
    private ArrayList<String> names;
    private boolean success =  true;

    public ListResponse(ArrayList<String> names){
        this.names = names;
    }

    public ListResponse(ArrayList<String> names, Boolean success) {
        this.names = names;
        this.success = success;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
