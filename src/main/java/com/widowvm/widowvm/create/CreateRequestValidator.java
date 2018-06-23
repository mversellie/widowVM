package com.widowvm.widowvm.create;

import com.widowvm.widowvm.interfaces.RequestValidator;

public class CreateRequestValidator extends RequestValidator{


    public CreateRequestValidator(CreateRequest createRequest) {
        super(createRequest);
    }


    @Override
    public boolean isRequestValid() {

        CreateRequest createRequest = (CreateRequest) requestInterface;


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
