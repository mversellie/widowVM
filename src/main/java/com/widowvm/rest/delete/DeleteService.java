package com.widowvm.rest.delete;

import com.widowvm.rest.create.CreateRequestValidator;
import com.widowvm.rest.create.CreateResponse;
import com.widowvm.rest.create.CreateScriptGenerator;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {

    public static DeleteResponse deleteVm(DeleteRequest request){
        DeleteRequestValidator requestValidator = new DeleteRequestValidator(request);
        /*
        if(!requestValidator.isRequestValid()){
            return new CreateResponse(request.getName(),400);
        }

        */
        String script = DeleteScriptGenerator.generateScript(request);

        ProcessBuilder processBuilder = new ProcessBuilder("sh","-c",script);
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

        try {
            Process deleteKvm = processBuilder.start();
            deleteKvm.waitFor();
            //Integer exitCode = createKvm.exitValue();
            Integer statusCode = 200;
                    //exitCode == 0 ? 200 : 400;
            return new DeleteResponse(request.getName(),statusCode,true);
        }

        catch(Exception exception){
        /*    exception.printStackTrace();
            return new CreateResponse(createRequest.getName(),400);
        */
        }

        return null;
    }
}
