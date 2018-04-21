package com.widowvm.rest.create;

public class CreateRequest {
    private final String name;
    private final Integer size;
    private final Integer memory;
    private final Integer vCpus;

    public CreateRequest(String name, Integer size, Integer memory, Integer vCpus) {
        this.name = name;
        this.size = size;
        this.memory = memory;
        this.vCpus = vCpus;
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getMemory() {
        return memory;
    }

    public Integer getvCpus() {
        return vCpus;
    }

}
