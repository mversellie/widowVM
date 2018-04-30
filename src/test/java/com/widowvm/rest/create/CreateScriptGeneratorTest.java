package com.widowvm.rest.create;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.widowvm.rest.create.*;

import java.nio.file.Files;
import java.nio.file.Paths;

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
        CreateScriptGenerator createScriptGenerator = new CreateScriptGenerator(new CreateRequest("myVM",20,34,2));
        assert(createScriptGenerator.generateScript() instanceof String);
    }

    @Test
    public void doesGenerateScriptReturnCorrectCommand() throws Exception{
        String validJsonLocation = System.getProperty("user.dir") +"/src/test/resources/validCreateScript.sh";
        CreateRequest createRequest = new CreateRequest("myVM",20,2048,1);
        String correctScript = new String (Files.readAllBytes(Paths.get(validJsonLocation)));
        System.out.println(correctScript);
        CreateScriptGenerator createScriptGenerator = new CreateScriptGenerator(createRequest);
        assertEquals(correctScript,createScriptGenerator.generateScript());
    }
}