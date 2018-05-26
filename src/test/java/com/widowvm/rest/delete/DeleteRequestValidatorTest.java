package com.widowvm.rest.delete;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteRequestValidatorTest {

    @Test
    public void doesValidatorReturnFalseIfNameBlank() {
        DeleteRequest request = new DeleteRequest("");
        DeleteRequestValidator validator = new DeleteRequestValidator(request);
        assertFalse(validator.isRequestValid());
    }

    @Test
    public void doesValidateReturnTrueIfNameExists() {
        DeleteRequest request = new DeleteRequest("requestName");
        DeleteRequestValidator validator = new DeleteRequestValidator(request);
        assertTrue(validator.isRequestValid());
    }
}