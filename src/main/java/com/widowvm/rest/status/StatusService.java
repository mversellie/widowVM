package com.widowvm.rest.status;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;


@Service
public class StatusService {

    public static StatusResponse getVmStatus(StatusRequest statusRequest) {
        String script = StatusScriptGenerator.generateScript(statusRequest);

        ProcessBuilder processBuilder = new ProcessBuilder("sh","-c",script);


        try {
            String output = IOUtils.toString(processBuilder.start().getInputStream());

            VirshOutputParser parser = new VirshOutputParser(output);

            AttributeResponseFormatter formatter =
                    new AttributeResponseFormatter(parser.getAttributeMap());

            return formatter.getResponse();
        }

        catch(Exception exception){
            exception.printStackTrace();
            return new StatusResponse();
        }
    }
}
