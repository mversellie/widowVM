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
        CreateResponse expectedResponse = new CreateResponse("controllerCreateVmTest",true);

        when(createService.createVm(any())).thenReturn(expectedResponse);

        //act
        CreateResponse actualResponse = widowVmController.createVm(createRequest);

        //assert
        verify(createService).createVm(any());
        assert(actualResponse.getName()).equals(expectedResponse.getName());
        assert(actualResponse.isSuccess() == expectedResponse.isSuccess());
    }

    @Test
    public void createVmWithInvalidRequest() throws Exception {
        CreateRequest createRequest = new CreateRequest("",0,0,0);
        CreateResponse expectedResponse = new CreateResponse("",false);

        when(createService.createVm(any())).thenReturn(expectedResponse);

        //act
        CreateResponse actualResponse = widowVmController.createVm(createRequest);

        //assert
        verify(createService).createVm(any());
        assert(actualResponse.getName()).equals(expectedResponse.getName());
        assert(actualResponse.isSuccess() == expectedResponse.isSuccess());

    }

    @Test
    public void statusVmWithValidRequest() throws Exception{
        //arrange
        StatusResponse expectedResponse = StatusExpectedResponseMother.generateExpectedCorrectResponse();
        String vmName = expectedResponse.getName();


        when(statusService.getVmStatus(any())).thenReturn(expectedResponse);

        //act
        StatusResponse actualResponse = widowVmController.getVmStatus(vmName);

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


    }

    @Test
    public void deleteVmWithValidRequest() throws Exception{
        //arrange
        DeleteResponse expectedResponse = DeletionExpectedResponseMother.generateDeletedResponse();
        DeleteRequest testRequest = new DeleteRequest("test");

        when(deleteService.deleteVm(any())).thenReturn(expectedResponse);

        //act
        DeleteResponse actualResponse = widowVmController.deleteVm(testRequest);

        //assert
        verify(deleteService).deleteVm(any());
        Assert.assertEquals(actualResponse.isSuccess(),expectedResponse.isSuccess());
        Assert.assertEquals(actualResponse.getName(),expectedResponse.getName());
    }

/*
    @Test
    public void listVm() throws Exception{
        ListResponse listResponse = ListExpectedResponseMother.expectedResponse();
        given(widowVmController.listVms()).willReturn(listResponse);
        mockMvc.perform(get("/kvm/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(ListExpectedResponseMother.expectedResponseAsString));
    }
  */
}