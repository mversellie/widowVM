package com.widowvm.rest.create.kickstart;

import com.widowvm.rest.create.CreateRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class KickStartFileFormatterTest {

    CreateRequest request;
    String outputKickstartContents;
    ArrayList<String> kickStartLines;

    @Before
    public void setUp() throws Exception {
        KickStartFileFormatter actualFormatter = new KickStartFileFormatter();
        request =  generateTestRequest();
        outputKickstartContents = KickStartFileFormatter.formatRequest(request);
        kickStartLines = KickStartFileValueListParser.listKickStartContent(outputKickstartContents);
    }

    @Test
    public void doesFormatterReturnAString() {
        assertNotNull(outputKickstartContents);
    }

    @Test
    public void IfNoAdditionalOptionsArePresentAreDefaultsPresent() throws IOException {
        //create testable output
        CreateRequest requestWithNoOptions = new CreateRequest("name",10,500,1) ;
        String actualKickstartContents = KickStartFileFormatter.formatRequest(requestWithNoOptions);
        kickStartLines = KickStartFileValueListParser.listKickStartContent(actualKickstartContents);

        //test
        ArrayList<String> expectedKickStartList = KickStartExpectedListMother.generateExpectedDefaultList();
        for(int i = 0; i <expectedKickStartList.size();i++){
            assertEquals(expectedKickStartList.get(i), kickStartLines.get(i));
        }
    }

    @Test
    public void formatWithAdditionalOptions() {
        ArrayList<String> expectedKickStartList = KickStartExpectedListMother.generateExpectedOptionsList();

        for(int i = 0; i <expectedKickStartList.size();i++){
            assertEquals(expectedKickStartList.get(i), kickStartLines.get(i));
        }
    }


    private CreateRequest generateTestRequest(){
        CreateRequest request = new CreateRequest("name",10,500,1) ;

        request.getAdditionalOptions().put("rootPassword","rootPassword!");
        request.getAdditionalOptions().put("encryptRootPassword",true);
        request.getAdditionalOptions().put("sudoUser","testUser");
        request.getAdditionalOptions().put("sudoPassword", "sudoPass");

        return request;
    }
}