package com.widowvm.widowvm.list;

import java.util.ArrayList;

public class ListResponse {
    private ArrayList<String> names;
    private Integer status =  200;

    public ListResponse(ArrayList<String> names){
        this.names = names;
    }

    public ListResponse(ArrayList<String> names, Integer status) {
        this.names = names;
        this.status = status;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
