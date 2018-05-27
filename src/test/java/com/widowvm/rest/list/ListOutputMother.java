package com.widowvm.rest.list;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ListOutputMother {

    public static String getAListOutput() throws IOException {
        String listExampleLocation = System.getProperty("user.dir") +"/src/test/resources/exampleListOutput.txt";
        return new String (Files.readAllBytes(Paths.get(listExampleLocation)));
    }

    public static ArrayList<String> getArrayRepresentation(){
        ArrayList<String> machines = new ArrayList();
        machines.add("vmA");
        machines.add("vmH");
        machines.add("VMHLB");
        return machines;
    }
}
