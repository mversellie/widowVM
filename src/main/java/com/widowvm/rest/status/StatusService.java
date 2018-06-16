package com.widowvm.rest.status;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;


@Service
public class StatusService {

    public StatusResponse getVmStatus(StatusRequest statusRequest) {
        String script = StatusScriptGenerator.generateScript(statusRequest);
        StatusResponse response;

        ProcessBuilder processBuilder = new ProcessBuilder("sh","-c",script);

        try {
            Process statusProcess = processBuilder.start();
            statusProcess.waitFor();
            String output = IOUtils.toString(statusProcess.getInputStream());

            Integer exitCode = statusProcess.exitValue();
            Integer statusCode = exitCode == 0 ? 200 : 400;
            Boolean vmFound = exitCode == 0 ? true : false;

            if(vmFound) {
                StatusOutputParser parser = new StatusOutputParser(output);
                AttributeResponseFormatter formatter =
                        new AttributeResponseFormatter(parser.getAttributeMap());

                response = formatter.getResponse();
            }

            else{
                response = new StatusResponse();
                response.setName(statusRequest.getName());
            }

            response.setVmFound(vmFound);
            response.setStatus(statusCode);

            return response;
        }

        catch(Exception exception){
            exception.printStackTrace();
            response = new StatusResponse(statusRequest.getName(),400);
            response.setVmFound(false);
            return response;
        }
    }
}
