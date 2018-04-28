package com.widowvm.rest.create;

import com.widowvm.rest.create.CreateRequest;
import com.widowvm.rest.create.CreateResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Runtime;

@Service
public class CreateService {

    public static CreateResponse createVm(CreateRequest createRequest) {
        CreateScriptGenerator createScriptGenerator = new CreateScriptGenerator(createRequest);
        String script = createScriptGenerator.generateScript();
        Runtime runtime = Runtime.getRuntime();

        try {
            Process process = runtime.exec(script );
            process.waitFor();

            java.io.InputStream is = process.getInputStream();
            java.io.BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));
            String s = null;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            is.close();
            return new CreateResponse(createRequest.getName(),200);
        }

        catch(Exception exception){
            return new CreateResponse(createRequest.getName(),400);
        }

    }

}
