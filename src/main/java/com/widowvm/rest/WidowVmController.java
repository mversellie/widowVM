package com.widowvm.rest;
import com.widowvm.rest.create.CreateRequest;
import com.widowvm.rest.create.CreateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WidowVmController {

    @PostMapping("/create")
    public CreateResponse createResponse(CreateRequest createRequest){
        return new CreateResponse();
    }

}
