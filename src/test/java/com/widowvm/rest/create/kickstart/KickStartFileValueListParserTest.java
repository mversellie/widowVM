package com.widowvm.rest.create.kickstart;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class KickStartFileValueListParserTest {

    ArrayList<String> actualKickStartList;

    @Before
    public void setUp() throws IOException {
        String kickStartExampleLocation = System.getProperty("user.dir") + "/src/test/resources/exampleKickStart.txt";
        String kickStartExampleText = new String(Files.readAllBytes(Paths.get(kickStartExampleLocation)));
        actualKickStartList = KickStartFileValueListParser.listKickStartContent(kickStartExampleText);
    }

    @Test
    public void doesMapperReturnValidNumberOfElements() {
        assertNotEquals(0, actualKickStartList.size());
        assertEquals(21, actualKickStartList.size());
    }

    @Test
    public void doesMapperReturnAllValidElements() {
        ArrayList<String> expectedKickStartList = KickStartExpectedListMother.generateExpectedDefaultList();
        for(int i = 0; i <expectedKickStartList.size();i++){
            assertEquals(expectedKickStartList.get(i), actualKickStartList.get(i));
        }

    }

}
