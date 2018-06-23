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
        assertEquals(expectedResponse.getName(),actualResponse.getName());
        assertEquals(expectedResponse.isSuccess(),actualResponse.isSuccess());
    }

    @Test
    public void doesTheDeleteServiceReturnAnInvalidResponse() {
        DeleteRequest badRequest = new DeleteRequest("wrongVm");
        DeleteResponse expectedResponse = new DeleteResponse("wrongVm", false );
        DeleteResponse actualResponse = deleteService.deleteVm(badRequest);
        assertEquals(expectedResponse.getName(),actualResponse.getName());
        assertEquals(expectedResponse.isSuccess(),actualResponse.isSuccess());
    }

    @Test
    public void doesTeDeleteServiceReturnAnInvalidResponseToAnInvalidRequest() {
        DeleteRequest badRequest = new DeleteRequest("");
        DeleteResponse expectedResponse = new DeleteResponse("", false );
        DeleteResponse actualResponse = deleteService.deleteVm(badRequest);
        assertEquals(expectedResponse.getName(),actualResponse.getName());
        assertEquals(expectedResponse.isSuccess(),actualResponse.isSuccess());
    }

    public DeleteResponse createExpectedCorrectResponse(){
        return new DeleteResponse("deleteVm1", true );
    }

}