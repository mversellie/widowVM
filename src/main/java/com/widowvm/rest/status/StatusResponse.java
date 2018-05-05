package com.widowvm.rest.status;

import sun.font.CoreMetrics;

public class StatusResponse {
    private Integer memory = 0;
    private Integer vCpus = 0;
    private String name = "";
    private boolean isRunning = false;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
