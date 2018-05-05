package com.widowvm.rest.status;

import java.util.HashMap;

public class AttributeResponseFormatter {

    private StatusResponse response;

    public AttributeResponseFormatter(HashMap<String, String> attributeMap) {
        response = new StatusResponse();
        formatMemory(attributeMap);
        formatVCpus(attributeMap);
        formatName(attributeMap);
        formatRunning(attributeMap);

    }

    private void formatVCpus(HashMap<String, String> attributeMap) {
        Integer vCpus = new Integer(attributeMap.get("CPU(s)"));
        response.setvCpus(vCpus);
    }


    private void formatName(HashMap<String, String> attributeMap){
        String name = attributeMap.get("Name");
        response.setName(name);
    }

    private void formatRunning(HashMap<String, String> attributeMap){
        String runningString = attributeMap.get("State");
        boolean running = runningString.equals("running");
        response.setRunning(running);
    }

    private void formatMemory(HashMap<String, String> attributeMap){
        Integer memory = new Integer(attributeMap.get("Max memory").split("\\s")[0]);
        Integer memoryInMb = memory / 1000;
        response.setMemory(memoryInMb);
    }

    public StatusResponse getResponse() {
        return response;
    }



}
