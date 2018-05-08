package com.widowvm.rest.create;

import org.springframework.stereotype.Service;

@Service
public class CreateService {

    public static CreateResponse createVm(CreateRequest createRequest) {
        CreateRequestValidator requestValidator = new CreateRequestValidator(createRequest);

        if(!requestValidator.isRequestValid()){
            return new CreateResponse(createRequest.getName(),400);
        }

        CreateScriptGenerator createScriptGenerator = new CreateScriptGenerator(createRequest);
        String script = createScriptGenerator.getScript();

        ProcessBuilder processBuilder = new ProcessBuilder("sh","-c",script);
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

        try {
            Process createKvm = processBuilder.start();
            createKvm.waitFor();
            Integer exitCode = createKvm.exitValue();
            Integer statusCode = exitCode == 0 ? 200 : 400;
            return new CreateResponse(createRequest.getName(),statusCode);
        }

        catch(Exception exception){
            exception.printStackTrace();
            return new CreateResponse(createRequest.getName(),400);
        }

    }

}
