package com.widowvm.widowvm.delete;

import org.springframework.stereotype.Service;

@Service
public class DeleteService {

    public DeleteResponse deleteVm(DeleteRequest request){
        DeleteRequestValidator requestValidator = new DeleteRequestValidator(request);

        if(!requestValidator.isRequestValid()){
            return new DeleteResponse("",false);
        }

        String script = DeleteScriptGenerator.generateScript(request);

        ProcessBuilder processBuilder = new ProcessBuilder("sh","-c",script);
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

        try {
            Process deleteKvm = processBuilder.start();
            deleteKvm.waitFor();
            Integer exitCode = deleteKvm.exitValue();
            Boolean deletionStatus =  exitCode == 0 ? true : false;
            return new DeleteResponse(request.getName(),deletionStatus);
        }

        catch(Exception exception){
            return new DeleteResponse(request.getName(),false);

        }

    }
}
