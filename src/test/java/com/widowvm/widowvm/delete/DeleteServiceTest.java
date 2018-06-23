package com.widowvm.widowvm.delete;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteServiceTest {
    DeleteRequest request;
    String vmName ;

    private DeleteService deleteService = new DeleteService();

    @Before
    public void setUp() throws Exception {
        vmName = "deleteVm1";
        request = new DeleteRequest(vmName);
    }

    @Test
    public void doesTheDeleteServiceWorkWithValidResponseAndVm() {
        DeleteResponse actualResponse = deleteService.deleteVm(request);
        DeleteResponse expectedResponse = createExpectedCorrectResponse();
        assertEquals(expectedResponse.isDeletionStatus(), actualResponse.isDeletionStatus());
        assertEquals(expectedResponse.getName(),actualResponse.getName());
        assertEquals(expectedResponse.getStatus(),actualResponse.getStatus());
    }

    @Test
    public void doesTheDeleteServiceReturnAnInvalidResponse() {
        DeleteRequest badRequest = new DeleteRequest("wrongVm");
        DeleteResponse expectedResponse = new DeleteResponse("wrongVm", 400 , false);
        DeleteResponse actualResponse = deleteService.deleteVm(badRequest);
        assertEquals(expectedResponse.isDeletionStatus(), actualResponse.isDeletionStatus());
        assertEquals(expectedResponse.getName(),actualResponse.getName());
        assertEquals(expectedResponse.getStatus(),actualResponse.getStatus());
    }

    @Test
    public void doesTeDeleteServiceReturnAnInvalidResponseToAnInvalidRequest() {
        DeleteRequest badRequest = new DeleteRequest("");
        DeleteResponse expectedResponse = new DeleteResponse("", 400 , false);
        DeleteResponse actualResponse = deleteService.deleteVm(badRequest);
        assertEquals(expectedResponse.isDeletionStatus(), actualResponse.isDeletionStatus());
        assertEquals(expectedResponse.getName(),actualResponse.getName());
        assertEquals(expectedResponse.getStatus(),actualResponse.getStatus());
    }

    public DeleteResponse createExpectedCorrectResponse(){
        return new DeleteResponse("deleteVm1", 200 , true);
    }

}