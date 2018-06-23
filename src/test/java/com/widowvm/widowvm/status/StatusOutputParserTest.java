package com.widowvm.widowvm.status;

import org.junit.Before;
import org.junit.Test;


public class StatusOutputParserTest {

    private StatusOutputParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new StatusOutputParser(VirshOutputMother.getAVirshOuput());
    }

    @Test
    public void returnsAMapOfValuesWithAtLeastOneEntry() {
        assert(!parser.getAttributeMap().isEmpty());
    }
}
