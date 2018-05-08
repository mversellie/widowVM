package com.widowvm.rest.status;

import java.util.Map;

public class AttributeResponseFormatter {

    private StatusResponse response;

    public AttributeResponseFormatter(Map<String, String> attributeMap) {
        response = new StatusResponse();
        formatMemory(attributeMap);
        formatVCpus(attributeMap);
        formatName(attributeMap);
        formatRunning(attributeMap);

    }

    private void formatVCpus(Map<String, String> attributeMap) {
        Integer vCpus = new Integer(attributeMap.get("CPU(s)"));
        response.setvCpus(vCpus);
    }


    private void formatName(Map<String, String> attributeMap){
        String name = attributeMap.get("Name");
        response.setName(name);
    }

    private void formatRunning(Map<String, String> attributeMap){
        String runningString = attributeMap.get("State");
        boolean running = runningString.equals("running");
        response.setRunning(running);
    }

    private void formatMemory(Map<String, String> attributeMap){
        Integer memory = new Integer(attributeMap.get("Max memory").split("\\s")[0]);
        Integer memoryInMb = memory / 1000;
        response.setMemory(memoryInMb);
    }

    public StatusResponse getResponse() {
        return response;
    }



}
