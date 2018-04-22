package com.widowvm.rest.create;

public class CreateRequestValidator {
    private CreateRequest createRequest;

    public CreateRequestValidator(CreateRequest createRequest) {
        this.createRequest = createRequest;
    }

    public boolean isRequestValid() {
        try {
            if (createRequest.getSize() <= 0) {
                return false;
            }

            if (createRequest.getMemory() <= 0) {
                return false;
            }

            if (createRequest.getName().length() == 0) {
                return false;
            }

            if (createRequest.getvCpus() <= 0) {
                return false;
            }
        } catch (NullPointerException badNewsBears) {
            return false;
        }


        return true;
    }
}
