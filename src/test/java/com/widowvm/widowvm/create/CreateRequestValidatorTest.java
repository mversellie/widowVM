package com.widowvm.widowvm.create;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateRequestValidatorTest {
    @Test
    public void verifyRequestIsInvalidOnNegativeSizeInteger(){
        CreateRequest createRequest = new CreateRequest("vmMachine",-1,1000,1,"virbr0");
        CreateRequestValidator createRequestValidator = new CreateRequestValidator(createRequest);
        assertFalse(createRequestValidator.isRequestValid());
    }

    @Test
    public void verifyRequestIsInvalidIfNameIsEmpty() {
        CreateRequest createRequest = new CreateRequest("",1,1000,1,"virbr0");
        CreateRequestValidator createRequestValidator = new CreateRequestValidator(createRequest);
        assertFalse(createRequestValidator.isRequestValid());
    }

    @Test
    public void verifyRequestIsInvalidIfMemoryIsZeroOrLess() {
        CreateRequest createRequest = new CreateRequest("myName",1,0,1,"virbr0");
        CreateRequestValidator createRequestValidator = new CreateRequestValidator(createRequest);
        assertFalse(createRequestValidator.isRequestValid());
    }

    @Test
    public void verifyRequestIsInvalidIfVcpusAreLessThan1() {
        CreateRequest createRequest = new CreateRequest("myName",1,1024,0,"virbr0");
        CreateRequestValidator createRequestValidator = new CreateRequestValidator(createRequest);
        assertFalse(createRequestValidator.isRequestValid());
    }

    @Test
    public void verifyRequestIsInvalidIfAFieldISNull(){
        CreateRequest createRequest = new CreateRequest(null,1,1024,1,"virbr0");
        CreateRequestValidator createRequestValidator = new CreateRequestValidator(createRequest);
        assertFalse(createRequestValidator.isRequestValid());
    }
}