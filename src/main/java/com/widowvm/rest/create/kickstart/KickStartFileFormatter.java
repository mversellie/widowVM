package com.widowvm.rest.create.kickstart;

import com.widowvm.rest.create.CreateRequest;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Map;

public class KickStartFileFormatter {
    public static String formatRequest(CreateRequest request){
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        Template scriptTemplate = velocityEngine.getTemplate("templates/Kickstart.vm");

        VelocityContext velocityContext = new VelocityContext();

        Map<String,Object> options = request.getAdditionalOptions();

            for (String key : options.keySet()) {
                velocityContext.put(key, options.get(key).toString());
            }


        StringWriter output = new StringWriter();

        scriptTemplate.merge(velocityContext,output);

        return output.toString();

    }

}
