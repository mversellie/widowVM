package com.widowvm.widowvm.create;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.widowvm.widowvm.interfaces.RequestInterface;

import java.util.HashMap;
import java.util.Map;

public class CreateRequest extends RequestInterface {
    private Integer size;
    private Integer memory;
    private Integer vCpus;
    private String networkInterface;
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
                         @JsonProperty("networkInterface") String networkInterface,
                         @JsonProperty("additionalOptions") Map<String,Object> options) {
        super(name);
        this.size = size;
        this.memory = memory;
        this.vCpus = vCpus;
        this.networkInterface = networkInterface;
        this.additionalOptions = options;
    }

    public CreateRequest(String name, Integer size, Integer memory, Integer vCpus, String networkInterface){
        super(name);
        this.size = size;
        this.memory = memory;
        this.vCpus = vCpus;
        this.additionalOptions = new HashMap();
        this.networkInterface = networkInterface;
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

    public String getNetworkInterface() {
        return networkInterface;
    }

    public void setNetworkInterface(String networkInterface) {
        this.networkInterface = networkInterface;
    }
}
