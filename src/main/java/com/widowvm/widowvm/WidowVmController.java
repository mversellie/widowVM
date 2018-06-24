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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CreateResponse> createVm(@RequestBody CreateRequest createRequest){
        CreateResponse responseBody = createService.createVm(createRequest);

        return  new ResponseEntity<CreateResponse>(responseBody,
                responseBody.isSuccess()? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/kvm/{vmName}/status")
    public ResponseEntity<StatusResponse> getVmStatus(@PathVariable("vmName") String vmName){
        StatusResponse responseBody = statusService.getVmStatus(new StatusRequest(vmName));

        return new ResponseEntity<StatusResponse>(responseBody,
                responseBody.isSuccess() ? HttpStatus.OK: HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/kvm/delete")
    public ResponseEntity<DeleteResponse> deleteVm(@RequestBody DeleteRequest deleteRequest){
        DeleteResponse responseBody = deleteService.deleteVm(deleteRequest);

        return new ResponseEntity<DeleteResponse>(responseBody,
                responseBody.isSuccess() ? HttpStatus.ACCEPTED: HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/kvm/list")
    public ListResponse listVms(){
        return listService.listVms();
    }

}
