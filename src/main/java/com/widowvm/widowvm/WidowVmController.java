package com.widowvm.widowvm;
import com.widowvm.widowvm.create.CreateRequest;
import com.widowvm.widowvm.create.CreateResponse;
import com.widowvm.widowvm.create.CreateService;
import com.widowvm.widowvm.delete.DeleteRequest;
import com.widowvm.widowvm.delete.DeleteResponse;
import com.widowvm.widowvm.delete.DeleteService;
import com.widowvm.widowvm.list.ListResponse;
import com.widowvm.widowvm.list.ListService;
import com.widowvm.widowvm.status.StatusRequest;
import com.widowvm.widowvm.status.StatusResponse;
import com.widowvm.widowvm.status.StatusService;
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

    @GetMapping("/kvm/{vmName}/status")
    public StatusResponse getVmStatus(@PathVariable("vmName") String vmName){
        return statusService.getVmStatus(new StatusRequest(vmName));
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
