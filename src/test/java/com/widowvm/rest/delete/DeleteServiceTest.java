package com.widowvm.rest.delete;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteServiceTest {
    DeleteRequest request;
    String vmName ;

    @Before
    public void setUp() throws Exception {
        vmName = "deleteVm";
        request = new DeleteRequest(vmName);
    }

    @Test
    public void doesTheDeleteServiceWorkWithValidResponseAndVm() {
        DeleteResponse actualResponse = DeleteService.deleteVm(request);
        DeleteResponse expectedResponse = createExpectedCorrectResponse();
        assertEquals(expectedResponse.isDeletionStatus(), actualResponse.isDeletionStatus());
        assertEquals(expectedResponse.getName(),actualResponse.getName());
        assertEquals(expectedResponse.getStatus(),actualResponse.getStatus());
    }

    @Test
    public void doesTheDeleteServiceReturnAnInvalidResponse() {
        DeleteRequest badRequest = new DeleteRequest("wrongVm");
        DeleteResponse expectedResponse = new DeleteResponse("wrongVm", 400 , false);
        DeleteResponse actualResponse = DeleteService.deleteVm(badRequest);
    }

    public DeleteResponse createExpectedCorrectResponse(){
        return new DeleteResponse("deleteVm", 200 , true);
    }

}