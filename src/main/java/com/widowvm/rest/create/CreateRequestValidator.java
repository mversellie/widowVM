package com.widowvm.rest.create;

import com.widowvm.rest.interfaces.RequestValidator;

public class CreateRequestValidator extends RequestValidator{


    public CreateRequestValidator(CreateRequest createRequest) {
        super(createRequest);
    }


    @Override
    public boolean isRequestValid() {

        CreateRequest createRequest = (CreateRequest)request;


        try {
            return  (createRequest.getSize() > 0)   &&
                    (createRequest.getMemory() > 0) &&
                    (createRequest.getvCpus() > 0)  &&
                    validateNameLength();

        }

        catch (NullPointerException badNewsBears) {
            return false;

        }
    }




}
