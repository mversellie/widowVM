package com.widowvm.rest.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListServiceTest {
    @Test
    public void isTheCorrectResponseGenerated() {
        ListResponse actualResponse = ListService.listVms();
        assertTrue(actualResponse.getNames().contains("listVm1"));
        assertTrue(actualResponse.getNames().contains("statusVm"));
        assertEquals((Integer)200,actualResponse.getStatus());
    }
}