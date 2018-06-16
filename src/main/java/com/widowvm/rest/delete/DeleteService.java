package com.widowvm.rest.delete;

import org.springframework.stereotype.Service;

@Service
public class DeleteService {

    public DeleteResponse deleteVm(DeleteRequest request){
        DeleteRequestValidator requestValidator = new DeleteRequestValidator(request);

        if(!requestValidator.isRequestValid()){
            return new DeleteResponse("",400,false);
        }

        String script = DeleteScriptGenerator.generateScript(request);

        ProcessBuilder processBuilder = new ProcessBuilder("sh","-c",script);
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

        try {
            Process deleteKvm = processBuilder.start();
            deleteKvm.waitFor();
            Integer exitCode = deleteKvm.exitValue();
            Integer statusCode = exitCode == 0 ? 200 : 400;
            Boolean deletionStatus =  exitCode == 0 ? true : false;
            return new DeleteResponse(request.getName(),statusCode,deletionStatus);
        }

        catch(Exception exception){
            exception.printStackTrace();
            return new DeleteResponse(request.getName(),400,false);

        }

    }
}
