package com.widowvm.rest.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public final class ListOutputParser {

    public static ArrayList<String> parse(String listOutput) throws IOException {
        ArrayList<String> machines = new ArrayList();
        BufferedReader reader = new BufferedReader(new StringReader(listOutput));
        String currentLine = reader.readLine();

        while(currentLine != null){
            if(!currentLine.equals("")) {
                machines.add(currentLine);
            }
            currentLine = reader.readLine();
        }

        return machines;
    }

}
