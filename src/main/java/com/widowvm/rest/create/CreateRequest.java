package com.widowvm.rest.create;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.widowvm.rest.interfaces.Request;

public class CreateRequest extends Request {
    private final Integer size;
    private final Integer memory;
    private final Integer vCpus;

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
                         @JsonProperty("vCpus") Integer vCpus) {

        super(name);
        this.size = size;
        this.memory = memory;
        this.vCpus = vCpus;
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

}
