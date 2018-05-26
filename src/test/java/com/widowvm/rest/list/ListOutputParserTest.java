package com.widowvm.rest.list;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListOutputParserTest {

    @Test
    public void parseValidFile() throws Exception{
        ArrayList<String> machines = ListOutputParser.parse(ListOutputMother.getAListOutput());
        assertEquals(machines.size(),3);
    }
}