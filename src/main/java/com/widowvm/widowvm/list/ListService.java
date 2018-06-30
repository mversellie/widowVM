package com.widowvm.widowvm.list;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {

    public static ListResponse listVms(){
        List<String> myVms;
        ListResponse response;

        String script = "virsh list --name";

        ProcessBuilder processBuilder = new ProcessBuilder("sh","-c",script);

        try {
            String output = IOUtils.toString(processBuilder.start().getInputStream());

            myVms = ListOutputParser.parse(output);
            response = new ListResponse(myVms,true);
            return response;
        }

        catch(Exception exception){
            return new ListResponse(new ArrayList<String>(),false);

        }

    }
}
