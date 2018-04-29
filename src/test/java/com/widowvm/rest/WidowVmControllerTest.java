package com.widowvm.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WidowVmControllerTest {

    @Autowired
    private WidowVmController widowVmController;

    @Test
    public void createVmDoesntBreak() {
        assert(widowVmController != null);
    }

    @Test
    public void createVmWorks(){

    }


    @Test
    public void isHelloReturned(){

    }


}