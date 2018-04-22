package com.widowvm.rest.create;

import org.springframework.data.repository.core.support.SurroundingTransactionDetectorMethodInterceptor;

public class CreateRequest {
    private final String name;
    private final Integer size;
    private final Integer memory;
    private final Integer vCpus;

    public  CreateRequest(){
        this.name = "";
        this.size = 0;
        this.memory = 0;
        this.vCpus = 0;
    }

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
