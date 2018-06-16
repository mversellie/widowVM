package com.widowvm.rest;

import com.widowvm.rest.create.CreateRequest;
import com.widowvm.rest.create.CreateResponse;
import com.widowvm.rest.create.CreateService;
import com.widowvm.rest.delete.DeleteRequest;
import com.widowvm.rest.delete.DeleteResponse;
import com.widowvm.rest.delete.DeleteService;
import com.widowvm.rest.delete.DeletionExpectedResponseMother;
import com.widowvm.rest.status.StatusExpectedResponseMother;
import com.widowvm.rest.status.StatusResponse;
import com.widowvm.rest.status.StatusService;
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
//@RunWith(SpringJUnit4ClassRunner.class)
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
        CreateResponse expectedResponse = new CreateResponse("controllerCreateVmTest",200);

        when(createService.createVm(any())).thenReturn(expectedResponse);

        //act
        CreateResponse actualResponse = widowVmController.createVm(createRequest);

        //assert
        verify(createService).createVm(any());
        assert(actualResponse.getName()).equals(expectedResponse.getName());
        assert(actualResponse.getStatus()).equals(expectedResponse.getStatus());
    }

    @Test
    public void createVmWithInvalidRequest() throws Exception {
        CreateRequest createRequest = new CreateRequest("",0,0,0);
        CreateResponse expectedResponse = new CreateResponse("",400);

        when(createService.createVm(any())).thenReturn(expectedResponse);

        //act
        CreateResponse actualResponse = widowVmController.createVm(createRequest);

        //assert
        verify(createService).createVm(any());
        assert(actualResponse.getName()).equals(expectedResponse.getName());
        assert(actualResponse.getStatus()).equals(expectedResponse.getStatus());

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
        Assert.assertEquals(expectedResponse.isVmFound(),actualResponse.isVmFound());
        Assert.assertEquals(expectedResponse.getStatus(),actualResponse.getStatus());
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
        Assert.assertEquals(actualResponse.getStatus(),expectedResponse.getStatus());
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