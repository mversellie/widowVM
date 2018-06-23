package com.widowvm.widowvm.status;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.widowvm.widowvm.interfaces.ResponseInterface;

import java.util.HashMap;
import java.util.Map;

public class StatusResponse extends ResponseInterface {

    private Map<String,Object> attributes = new HashMap();

    public StatusResponse(){
        super("");
    }

    public StatusResponse(String name, Boolean status) {
        super(name,status);
    }

    @JsonIgnore
    public boolean isRunning() {
        return (boolean)attributes.get("isRunning");
    }

    public void setRunning(boolean running) {
        attributes.put("isRunning",running);
    }

    @JsonIgnore
    public Integer getMemory() {
        return (Integer)attributes.get("memory");
    }

    public void setMemory(Integer memory) {
        attributes.put("memory",memory);
    }

    @JsonIgnore
    public Integer getvCpus() {
        return (Integer)attributes.get("vCpus");
    }

    public void setvCpus(Integer vCpus) {
        attributes.put("vCpus",vCpus);
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
