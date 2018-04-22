package com.widowvm.rest.create;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.widowvm.rest.create.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateScriptGeneratorTest {

    @Before
    public void setUp() throws Exception {
        CreateScriptGenerator createScriptGenerator = new CreateScriptGenerator();
    }

    @Test
    public void doesGenerateScriptReturnAString() {
        CreateScriptGenerator createScriptGenerator = new CreateScriptGenerator();
        assert(createScriptGenerator.generateScript() instanceof String);
    }
}