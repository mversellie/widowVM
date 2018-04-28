package com.widowvm.rest.create;

import com.widowvm.rest.create.CreateRequest;
import com.widowvm.rest.create.CreateResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Runtime;

@Service
public class CreateService {

    public static CreateResponse createVm(CreateRequest createRequest) {
        CreateScriptGenerator createScriptGenerator = new CreateScriptGenerator(createRequest);
        String script = createScriptGenerator.generateScript();

        ProcessBuilder processBuilder = new ProcessBuilder("sh","-c",script);
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

       // Runtime runtime = Runtime.getRuntime();

        try {
            Process createKvm = processBuilder.start();
            /**
            Process process = runtime.exec(script );
            InputStream stdout =  process.getInputStream();
            InputStream stdError = process.getErrorStream();



            BufferedReader errorRreader =
                    new BufferedReader(
                            new InputStreamReader(process.getErrorStream()));
            String s = null;
            while ((s = errorRreader.readLine()) != null) {
                System.out.println(s);
            }

            int badStuff = process.waitFor();
            System.out.println(badStuff);
             **/
            return new CreateResponse(createRequest.getName(),200);
        }

        catch(Exception exception){
            exception.printStackTrace();
            return new CreateResponse(createRequest.getName(),400);
        }

    }

}
