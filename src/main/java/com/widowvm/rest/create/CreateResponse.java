package com.widowvm.rest.create;

public class CreateResponse {
    private String name;
    private Integer vCpus;
    private Integer size;
    private Integer memory;

    public CreateResponse() {
    }

    public CreateResponse(String name, Integer size, Integer memory, Integer vCpu) {
        this.name = name;
        this.vCpus = vCpus;
        this.size = size;
        this.memory = memory;
    }

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getvCpus() {
        return vCpus;
    }

    public void setvCpus(Integer vCpus) {
        this.vCpus = vCpus;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }
}
