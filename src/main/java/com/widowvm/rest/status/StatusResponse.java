package com.widowvm.rest.status;


import com.widowvm.rest.interfaces.Response;

public class StatusResponse extends Response{
    private Integer memory = 0;
    private Integer vCpus = 0;
    private boolean isRunning = false;

    public StatusResponse(){
        super("");
    }

    public StatusResponse(String name, Integer status) {
        super(name,status);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public Integer getvCpus() {
        return vCpus;
    }

    public void setvCpus(Integer vCpus) {
        this.vCpus = vCpus;
    }
}
