package com.widowvm.widowvm.create;

import com.widowvm.widowvm.interfaces.RequestValidator;

public class CreateRequestValidator extends RequestValidator{

    public CreateRequestValidator(CreateRequest createRequest) {
        super(createRequest);
    }


    @Override
    public boolean isRequestValid() {

        CreateRequest createRequest = (CreateRequest) this.requestInterface;


        try {
            return  (createRequest.getSize() > 0)   &&
                    (createRequest.getMemory() > 0) &&
                    (createRequest.getvCpus() > 0)  &&
                    validateLowerCase((String)findOptionalFieldValue("sudoUser")) &&
                    !((String) findOptionalFieldValue("sudoUser")).contains(" ") &&
                    ((String) findOptionalFieldValue("sudoUser")).length() < 33 &&
                    validateNameLength();
        }

        catch (NullPointerException badNewsBears) {
            return false;
        }
    }

    private Object findOptionalFieldValue(String field){
        CreateRequest createRequest = (CreateRequest) this.requestInterface;

        return createRequest.getAdditionalOptions().get(field);
    }


    private boolean validateLowerCase(String inString){
        if( inString.length() != 0){
            return inString.equals(inString.toLowerCase());
        }

        return false;
    }







}
