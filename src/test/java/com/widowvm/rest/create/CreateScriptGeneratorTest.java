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
        CreateScriptGenerator createScriptGenerator = new CreateScriptGenerator(new CreateRequest("myVM",20,34,2));
        assert(createScriptGenerator.generateScript() instanceof String);
    }

    @Test
    public void doesGenerateScriptReturnCorrectCommand(){
        CreateRequest createRequest = new CreateRequest("myVM",20,34,2);
        String correctString = "virt-install -n myVM --vcpus=2 -r 34 --os-type=linux --disk /home/jenkins/images/jenkins_dev.img,device=disk,bus=virtio -w   bridge=br1,model=virtio --vnc --noautoconsole --import";
        CreateScriptGenerator createScriptGenerator = new CreateScriptGenerator(createRequest);
        assertEquals(correctString,createScriptGenerator.generateScript());
    }
}