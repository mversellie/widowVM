package com.widowvm.rest.create;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.widowvm.rest.interfaces.Request;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CreateRequest extends Request {
    private final Integer size;
    private final Integer memory;
    private final Integer vCpus;
    private Map<String,Object> additionalOptions;

    public CreateRequest(){
        super("");
        this.size = 0;
        this.memory = 0;
        this.vCpus = 0;
    }

    @JsonCreator
    public CreateRequest(@JsonProperty("name") String name,
                         @JsonProperty("size") Integer size,
                         @JsonProperty("memory") Integer memory,
                         @JsonProperty("vCpus") Integer vCpus,
                         @JsonProperty("additionalOptions") Map<String,Object> options) {
        super(name);
        this.size = size;
        this.memory = memory;
        this.vCpus = vCpus;
        this.additionalOptions = options;
    }

    public CreateRequest(String name,Integer size,Integer memory,Integer vCpus){
        super(name);
        this.size = size;
        this.memory = memory;
        this.vCpus = vCpus;
        this.additionalOptions = new HashMap();
    }


    public Map<String, Object> getAdditionalOptions() {
        return additionalOptions;
    }

    public Integer getSize() {
        return size;
    }

    public String toString() {
        return super.toString();
    }

    public Integer getMemory() {
        return memory;
    }

    public Integer getvCpus() {
        return vCpus;
    }

    public void setAdditionalOptions(Map<String, Object> additionalOptions) {
        this.additionalOptions = additionalOptions;
    }

    public boolean hasExtraOptions(){
        return !additionalOptions.isEmpty();
    }
}
