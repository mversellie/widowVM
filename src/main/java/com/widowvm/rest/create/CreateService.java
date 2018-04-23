package com.widowvm.rest.create;

import com.widowvm.rest.create.CreateRequest;
import com.widowvm.rest.create.CreateResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.Runtime;

@Service
public class CreateService {

    public static CreateResponse createVm(CreateRequest createRequest) {
        CreateScriptGenerator createScriptGenerator = new CreateScriptGenerator(createRequest);
        String script = createScriptGenerator.generateScript();
        Runtime runtime = Runtime.getRuntime();
        String sshString = "ssh jenkins@markov '";
        try {
            Process process = runtime.exec(sshString + script + "'");
            return new CreateResponse(createRequest.getName(),200);
        }

        catch(IOException exception){
            return new CreateResponse(createRequest.getName(),400);
        }

    }

}
