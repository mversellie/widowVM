package com.widowvm.widowvm.create.kickstart;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KickStartFileGeneratorTest {
    String filePath;

    @Before
    public void setUp() throws Exception {
        filePath = KickStartFileGenerator.generateKickStartFile("ThisIsUseless");
        System.out.println(filePath);
    }

    @Test
    public void seeIfAStringIsGenerated() {
        assertNotNull(filePath);
    }

    @Test
    public void makeSureReturnedValueIsntInvalid() {
        assertNotEquals("INVALID",filePath);
    }

    @Test
    public void seeIfStringIsAtLeastNineteenCharsLong(){
        assertTrue(filePath.length() > 18 );
    }

    @Test
    public void seeIfGetFilenameFromPathReturnsCorrectFilename() {
        String filepath = "/things/path/from/correctFilename.ks";
        assertEquals(KickStartFileGenerator.getFilenameFromPath(filepath),"correctFilename.ks");
    }
}