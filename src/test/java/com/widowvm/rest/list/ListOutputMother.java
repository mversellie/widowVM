package com.widowvm.rest.list;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListOutputMother {
    public static String getAListOutput() throws IOException {
        String listExampleLocation = System.getProperty("user.dir") +"/src/test/resources/exampleListOutput.txt";
        return new String (Files.readAllBytes(Paths.get(listExampleLocation)));
    }
}
