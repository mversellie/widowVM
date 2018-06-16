package com.widowvm.rest.create;

import com.widowvm.rest.create.kickstart.KickStartFileGenerator;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;

public class CreateScriptGenerator{


    public static String generateScript(CreateRequest createRequest){
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        Template scriptTemplate = velocityEngine.getTemplate("templates/Create.vm");

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("vCpus",createRequest.getvCpus());
        velocityContext.put("memory",createRequest.getMemory());
        velocityContext.put("name",createRequest.getName());
        velocityContext.put("size",createRequest.getSize());

        StringWriter output = new StringWriter();

        scriptTemplate.merge(velocityContext,output);

        return output.toString();
    }

    public static String generateScript(CreateRequest createRequest, String kickStartFilename){
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        Template scriptTemplate = velocityEngine.getTemplate("templates/Create.vm");

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("vCpus",createRequest.getvCpus());
        velocityContext.put("memory",createRequest.getMemory());
        velocityContext.put("name",createRequest.getName());
        velocityContext.put("size",createRequest.getSize());
        velocityContext.put("ksPath",kickStartFilename);
        velocityContext.put("ksName", KickStartFileGenerator.getFilenameFromPath(kickStartFilename));

        StringWriter output = new StringWriter();

        scriptTemplate.merge(velocityContext,output);

        return output.toString();
    }



}
