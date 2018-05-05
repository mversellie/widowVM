package com.widowvm.rest.status;

import org.junit.Before;
import org.junit.Test;

public class AttributeResponseFormatterTest {
    AttributeResponseFormatter formatter;
    StatusResponse expectedResponse;
    StatusResponse actualResponse;

    @Before
    public void setUp() throws Exception {
        VirshOutputParser virshParser = new VirshOutputParser(VirshOutputMother.getAVirshOuput());
        formatter = new AttributeResponseFormatter(virshParser.getAttributeMap());
        actualResponse = formatter.getResponse();
        generateExpectedResponse();
    }

    @Test
    public void returnsAResponse() {
        assert(actualResponse instanceof StatusResponse);
    }

    @Test
    public void isMemoryValid() {
        assert(expectedResponse.getMemory().equals(actualResponse.getMemory()));
    }

    @Test
    public void isVCpusValid() {
        assert(expectedResponse.getvCpus().equals(actualResponse.getvCpus()));
    }

    @Test
    public  void isNameValid(){
        assert(expectedResponse.getName().equals(actualResponse.getName()));
    }

    @Test
    public void isRunning() {
        assert(expectedResponse.isRunning() == actualResponse.isRunning());
    }

    public void generateExpectedResponse(){
        expectedResponse = new StatusResponse();
        expectedResponse.setMemory(8240);
        expectedResponse.setvCpus(4);
        expectedResponse.setName("Test");
        expectedResponse.setRunning(true);
    }

}
