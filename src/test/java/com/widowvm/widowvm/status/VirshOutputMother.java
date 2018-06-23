package com.widowvm.widowvm.status;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VirshOutputMother {
    public static String getAVirshOuput() throws IOException {
        String virshExampleLocation = System.getProperty("user.dir") +"/src/test/resources/exampleVirshOutput.txt";
        return new String (Files.readAllBytes(Paths.get(virshExampleLocation)));
    }
}
