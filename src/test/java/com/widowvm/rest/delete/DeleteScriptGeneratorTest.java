package com.widowvm.rest.delete;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteScriptGeneratorTest {

    @Test
    public void returnsValidDeleteScript() {
        String vmName = "vmToDelete";
        DeleteRequest request = new DeleteRequest(vmName);
        String actualScript = DeleteScriptGenerator.generateScript(request);
        String expectedScript = "virsh destroy " + vmName + " && virsh undefine " + vmName;
        assertEquals(actualScript,expectedScript);
    }
}