package com.widowvm.rest.delete;

import com.widowvm.rest.interfaces.RequestValidator;

public class DeleteRequestValidator extends RequestValidator {

    public DeleteRequestValidator(DeleteRequest request){
        super(request);
    }

    @Override
    public boolean isRequestValid() {
        return validateNameLength();
    }
}
