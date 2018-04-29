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
        CreateRequest createRequest = new CreateRequest("myVM",20,2048,1);
        String correctString = "virt-install --name 'myVM' --ram 2048 --disk path=/var/lib/libvirt/images/myVM,size=20 --vcpus 1 --os-type linux --os-variant ubuntuprecise --network bridge=virbr0 --graphics none --console pty,target_type=serial --location 'http://jp.archive.ubuntu.com/ubuntu/dists/precise/main/installer-amd64/' --extra-args 'console=ttyS0'";
        CreateScriptGenerator createScriptGenerator = new CreateScriptGenerator(createRequest);
        assertEquals(correctString,createScriptGenerator.generateScript());
    }
}