package com.widowvm.rest;
import com.widowvm.rest.create.CreateRequest;
import com.widowvm.rest.create.CreateResponse;
import com.widowvm.rest.create.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class WidowVmController {

    @Autowired
    private CreateService createService;

    @PostMapping("/create")
    public CreateResponse createResponse(@RequestBody CreateRequest createRequest){
        return createService.createVm(createRequest);
    }

}
