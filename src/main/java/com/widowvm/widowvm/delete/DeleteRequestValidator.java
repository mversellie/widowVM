package com.widowvm.widowvm.delete;

import com.widowvm.widowvm.interfaces.RequestValidator;

public class DeleteRequestValidator extends RequestValidator {

    public DeleteRequestValidator(DeleteRequest request){
        super(request);
    }

    @Override
    public boolean isRequestValid() {
        return validateNameLength();
    }
}
