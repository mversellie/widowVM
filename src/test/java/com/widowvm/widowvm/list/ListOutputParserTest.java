package com.widowvm.widowvm.list;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListOutputParserTest {

    @Test
    public void parseValidFile() throws Exception{
        List<String> machines = ListOutputParser.parse(ListOutputMother.getAListOutput());
        assertEquals(3,machines.size());
    }

}