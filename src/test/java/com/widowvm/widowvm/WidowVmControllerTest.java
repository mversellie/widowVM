package com.widowvm.widowvm;

import com.widowvm.widowvm.create.CreateRequest;
import com.widowvm.widowvm.create.CreateResponse;
import com.widowvm.widowvm.create.CreateService;
import com.widowvm.widowvm.delete.DeleteRequest;
import com.widowvm.widowvm.delete.DeleteResponse;
import com.widowvm.widowvm.delete.DeleteService;
import com.widowvm.widowvm.delete.DeletionExpectedResponseMother;
import com.widowvm.widowvm.status.StatusExpectedResponseMother;
import com.widowvm.widowvm.status.StatusResponse;
import com.widowvm.widowvm.status.StatusService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class WidowVmControllerTest {

    @InjectMocks
    private WidowVmController widowVmController;

    @Mock
    private DeleteService deleteService;

    @Mock
    private CreateService createService;

    @Mock
    private StatusService statusService;


    @Test
    public void createVmWithValidRequest() throws Exception {
        //arrange
        CreateRequest createRequest = new CreateRequest("controllerCreateVmTest",6,512,1);
        CreateResponse expectedResponseBody = new CreateResponse("controllerCreateVmTest",true);

        when(createService.createVm(any())).thenReturn(expectedResponseBody);

        //act
        ResponseEntity<CreateResponse> actualResponse = widowVmController.createVm(createRequest);

        //assert
        verify(createService).createVm(any());
        assert(actualResponse.getBody().getName()).equals(expectedResponseBody.getName());
        assert(actualResponse.getBody().isSuccess() == expectedResponseBody.isSuccess());
        assert(actualResponse.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void createVmWithInvalidRequest() throws Exception {
        CreateRequest createRequest = new CreateRequest("",0,0,0);
        CreateResponse expectedResponse = new CreateResponse("",false);

        when(createService.createVm(any())).thenReturn(expectedResponse);

        //act
        ResponseEntity<CreateResponse> actualResponse = widowVmController.createVm(createRequest);

        //assert
        verify(createService).createVm(any());
        assert(actualResponse.getBody().getName()).equals(expectedResponse.getName());
        assert(actualResponse.getBody().isSuccess() == expectedResponse.isSuccess());
        assert(actualResponse.getStatusCode().is4xxClientError());

    }

    @Test
    public void statusVmWithValidRequest() throws Exception{
        //arrange
        StatusResponse expectedResponse = StatusExpectedResponseMother.generateExpectedCorrectResponse();
        String vmName = expectedResponse.getName();


        when(statusService.getVmStatus(any())).thenReturn(expectedResponse);

        //act
        ResponseEntity<StatusResponse> fullResponse = widowVmController.getVmStatus(vmName);
        StatusResponse actualResponse = fullResponse.getBody();

        //assert
        verify(statusService).getVmStatus(any());
        Assert.assertArrayEquals(expectedResponse.getAttributes().keySet().toArray(),
                actualResponse.getAttributes().keySet().toArray());
        Assert.assertArrayEquals(expectedResponse.getAttributes().entrySet().toArray(),
                actualResponse.getAttributes().entrySet().toArray());
        Assert.assertEquals(expectedResponse.getMemory(),actualResponse.getMemory());
        Assert.assertEquals(expectedResponse.getvCpus(),actualResponse.getvCpus());
        Assert.assertEquals(expectedResponse.isRunning(),actualResponse.isRunning());
        Assert.assertEquals(expectedResponse.isSuccess(),actualResponse.isSuccess());
        Assert.assertEquals(expectedResponse.getName(),actualResponse.getName());
        Assert.assertEquals(fullResponse.getStatusCode(), HttpStatus.OK);


    }

    @Test
    public void deleteVmWithValidRequest() throws Exception{
        //arrange
        DeleteResponse expectedResponse = DeletionExpectedResponseMother.generateDeletedResponse();
        DeleteRequest testRequest = new DeleteRequest("test");

        when(deleteService.deleteVm(any())).thenReturn(expectedResponse);

        //act
        ResponseEntity<DeleteResponse> fullResponse = widowVmController.deleteVm(testRequest);
        DeleteResponse actualResponse = fullResponse.getBody();

        //assert
        verify(deleteService).deleteVm(any());
        Assert.assertEquals(actualResponse.isSuccess(),expectedResponse.isSuccess());
        Assert.assertEquals(actualResponse.getName(),expectedResponse.getName());
        Assert.assertEquals(fullResponse.getStatusCode(),HttpStatus.ACCEPTED);
    }


}