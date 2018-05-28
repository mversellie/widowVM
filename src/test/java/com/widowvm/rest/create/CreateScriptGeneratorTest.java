package com.widowvm.rest.create;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.widowvm.rest.create.*;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateScriptGeneratorTest {


    @Test
    public void doesGenerateScriptReturnAString() {
        CreateRequest testRequest = new CreateRequest("createVm",20,34,2);
        assert(CreateScriptGenerator.generateScript(testRequest) instanceof String);
    }

    @Test
    public void doesGenerateScriptReturnCorrectCommandNoKickstart() throws Exception{
        String validScriptLocation = System.getProperty("user.dir") +"/src/test/resources/validCreateScriptNoKickStart.sh";
        CreateRequest createRequest = new CreateRequest("createVm",20,2048,1);
        String correctScript = new String (Files.readAllBytes(Paths.get(validScriptLocation)));
        assertEquals(correctScript,CreateScriptGenerator.generateScript(createRequest));
    }
}