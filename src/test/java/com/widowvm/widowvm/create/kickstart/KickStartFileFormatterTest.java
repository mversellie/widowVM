package com.widowvm.widowvm.create.kickstart;

import com.widowvm.widowvm.create.CreateRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class KickStartFileFormatterTest {

    CreateRequest request;
    String outputKickstartContents;

    @Before
    public void setUp() throws Exception {
        KickStartFileFormatter actualFormatter = new KickStartFileFormatter();
        request =  generateTestRequest();
        outputKickstartContents = KickStartFileFormatter.formatRequest(request);
    }

    @Test
    public void doesFormatterReturnAString() {
        assertNotNull(outputKickstartContents);
    }

    @Test
    public void IfNoAdditionalOptionsArePresentAreDefaultsPresent() throws IOException {

        //arrange
        String kickStartExampleLocation = System.getProperty("user.dir") + "/src/test/resources/exampleKickstartForDefaultTest.txt";
        String expectedKickstarterText = new String(Files.readAllBytes(Paths.get(kickStartExampleLocation)));


        //act
        CreateRequest requestWithNoOptions = new CreateRequest("name",10,512,1,"virbr0") ;
        String actualKickstartContents = KickStartFileFormatter.formatRequest(requestWithNoOptions);


        //assert
        assertEquals(expectedKickstarterText,actualKickstartContents);
    }

    @Test
    public void formatWithAdditionalOptions() throws IOException {
        //arrange
        String kickStartExampleLocation = System.getProperty("user.dir") + "/src/test/resources/exampleKickstartwithAdditionalOptionsTest.txt";
        String expectedKickstarterText = new String(Files.readAllBytes(Paths.get(kickStartExampleLocation)));

        //act
        String actualKickstartContents = KickStartFileFormatter.formatRequest(generateTestRequest());


        //assert
        assertEquals(expectedKickstarterText,actualKickstartContents);
    }

    @Test
    public void formatWithAdditionalSoftwarePackages() throws IOException {

        //arrange
        String kickStartExampleLocation = System.getProperty("user.dir") + "/src/test/resources/exampleKickstartWithAdditionalPackages.txt";
        String expectedKickstarterText = new String(Files.readAllBytes(Paths.get(kickStartExampleLocation)));

        CreateRequest request = generateTestRequest();
        ArrayList<String> packages = new ArrayList<String>();
        packages.add("openssh-server");
        request.getAdditionalOptions().put("packages", packages);

        //act
        String actualKickstartContents = KickStartFileFormatter.formatRequest(request);


        //assert
        assertEquals(expectedKickstarterText,   actualKickstartContents);
    }

    private CreateRequest generateTestRequest(){
        CreateRequest request = new CreateRequest("name",10,512,1,"virbr0") ;
        request.getAdditionalOptions().put("sudoUser","testUser");
        request.getAdditionalOptions().put("sudoPassword", "sudoPass");
        request.getAdditionalOptions().put("fullName","aFullName");
        request.getAdditionalOptions().put("hostname","vmName");

        return request;
    }
}