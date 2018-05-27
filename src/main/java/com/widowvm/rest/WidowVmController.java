package com.widowvm.rest;
import com.widowvm.rest.create.CreateRequest;
import com.widowvm.rest.create.CreateResponse;
import com.widowvm.rest.create.CreateService;
import com.widowvm.rest.delete.DeleteRequest;
import com.widowvm.rest.delete.DeleteResponse;
import com.widowvm.rest.delete.DeleteService;
import com.widowvm.rest.list.ListResponse;
import com.widowvm.rest.list.ListService;
import com.widowvm.rest.status.StatusRequest;
import com.widowvm.rest.status.StatusResponse;
import com.widowvm.rest.status.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class WidowVmController {

    @Autowired
    private CreateService createService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private DeleteService deleteService;

    @Autowired
    private ListService listService;

    @PostMapping("/kvm/create")
    public CreateResponse createVm(@RequestBody CreateRequest createRequest){
        return createService.createVm(createRequest);
    }

    @PostMapping("/kvm/status")
    public StatusResponse getVmStatus(@RequestBody StatusRequest statusRequest){
        return statusService.getVmStatus(statusRequest);
    }

    @PostMapping("/kvm/delete")
    public DeleteResponse deleteVm(@RequestBody DeleteRequest deleteRequest){
        return deleteService.deleteVm(deleteRequest);
    }

    @GetMapping("/kvm/list")
    public ListResponse listVms(){
        return listService.listVms();
    }

}
