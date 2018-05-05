package com.widowvm.rest.create;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;

public class CreateScriptGenerator {


    private CreateRequest createRequest;

    public CreateScriptGenerator(CreateRequest arg){
        createRequest = arg;
    }

    public CreateScriptGenerator(){


    }

    public String generateScript(){
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        Template script = velocityEngine.getTemplate("templates/Create.vm");

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("vCpus",createRequest.getvCpus());
        velocityContext.put("memory",createRequest.getMemory());
        velocityContext.put("name",createRequest.getName());
        velocityContext.put("size",createRequest.getSize());

        StringWriter output = new StringWriter();

        script.merge(velocityContext,output);
        return output.toString();
    }



}
