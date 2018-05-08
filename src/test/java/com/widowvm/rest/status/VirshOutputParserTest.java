package com.widowvm.rest.status;

import org.junit.Before;
import org.junit.Test;


public class VirshOutputParserTest {

    VirshOutputParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new VirshOutputParser(VirshOutputMother.getAVirshOuput());
    }

    @Test
    public void returnsAMapOfValuesWithAtLeastOneEntry() {
        assert(!parser.getAttributeMap().isEmpty());
    }
}
