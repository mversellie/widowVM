package com.widowvm.widowvm.delete;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;

public class DeleteScriptGenerator{

    public static String generateScript(DeleteRequest request){
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        Template scriptTemplate = velocityEngine.getTemplate("templates/Delete.vm");

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("vmName",request.getName());

        StringWriter output = new StringWriter();

        scriptTemplate.merge(velocityContext,output);

        return output.toString();
    }
}
