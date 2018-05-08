package com.widowvm.rest.status;


import org.junit.Before;
import org.junit.Test;

public class StatusScriptGeneratorTest {

    private StatusScriptGenerator scriptGen;

    private StatusRequest request;

    private String TEST_VM_NAME = "vmName";
    private String EXPECTED_SCRIPT = "virsh dominfo " + TEST_VM_NAME;

    @Before
    public void setUp() throws Exception {
        request = new StatusRequest();
        request.setName(TEST_VM_NAME);
        scriptGen = new StatusScriptGenerator(request);
    }

    @Test
    public void doesScriptMatch() {
        assert(scriptGen.getScript().equals(EXPECTED_SCRIPT));
    }
}
