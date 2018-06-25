package com.widowvm.widowvm.create;

import com.widowvm.widowvm.create.kickstart.KickStartFileFormatter;
import com.widowvm.widowvm.create.kickstart.KickStartFileGenerator;
import org.springframework.stereotype.Service;

@Service
public class CreateService {

    public CreateResponse createVm(CreateRequest createRequest) {
        CreateRequestValidator requestValidator = new CreateRequestValidator(createRequest);

        if(!requestValidator.isRequestValid()){
            return new CreateResponse(createRequest.getName(),false);
        }

        String script;

        if(createRequest.hasExtraOptions()){
            String kickStartContents = KickStartFileFormatter.formatRequest(createRequest);
            String kickStartFileLocation = KickStartFileGenerator.generateKickStartFile(kickStartContents);

            System.out.println("********************************************");
            script = CreateScriptGenerator.generateScript(createRequest, kickStartFileLocation);
            System.out.println(script);
            System.out.println("********************************************");

            System.out.println(kickStartContents);
            System.out.println("*********************************************");
        }

        else {
            script = CreateScriptGenerator.generateScript(createRequest);
        }


        ProcessBuilder processBuilder = new ProcessBuilder("sh","-c",script);
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

        try {
            Process createKvm = processBuilder.start();
            createKvm.waitFor();
            Integer exitCode = createKvm.exitValue();
            Boolean statusCode = exitCode == 0 ? true : false;
            return new CreateResponse(createRequest.getName(),statusCode);
        }

        catch(Exception exception){
            exception.printStackTrace();
            return new CreateResponse(createRequest.getName(),false);
        }

    }



}
