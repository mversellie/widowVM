package com.widowvm.rest.status;

import org.junit.Before;
import org.junit.Test;

public class AttributeResponseFormatterTest {
    private AttributeResponseFormatter formatter;
    private StatusResponse expectedResponse;
    private StatusResponse actualResponse;

    @Before
    public void setUp() throws Exception {
        StatusOutputParser virshParser = new StatusOutputParser(VirshOutputMother.getAVirshOuput());
        formatter = new AttributeResponseFormatter(virshParser.getAttributeMap());
        actualResponse = formatter.getResponse();
        expectedResponse = StatusExpectedResponseMother.generateExpectedResponse();
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

}
