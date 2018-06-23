package com.widowvm.widowvm.status;


import org.junit.Before;
import org.junit.Test;

public class StatusScriptGeneratorTest {

    private StatusScriptGenerator scriptGen;

    private StatusRequest request;

    private String TEST_VM_NAME = "vmName";
    private String EXPECTED_SCRIPT = "virsh dominfo " + TEST_VM_NAME;

    @Before
    public void setUp() throws Exception {
        request = new StatusRequest(TEST_VM_NAME);
    }

    @Test
    public void doesScriptMatch() {
        assert(StatusScriptGenerator.generateScript(request).equals(EXPECTED_SCRIPT));
    }
}
