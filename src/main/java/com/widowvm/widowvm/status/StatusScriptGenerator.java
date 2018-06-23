package com.widowvm.widowvm.status;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;

public class StatusScriptGenerator{

    public static String generateScript(StatusRequest statusRequest){
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        Template scriptTemplate = velocityEngine.getTemplate("templates/Status.vm");

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("vmName",statusRequest.getName());

        StringWriter output = new StringWriter();

        scriptTemplate.merge(velocityContext,output);

        return output.toString();
    }

}
