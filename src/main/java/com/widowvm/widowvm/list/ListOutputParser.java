package com.widowvm.widowvm.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public final class ListOutputParser {

    public static List<String> parse(String listOutput) throws IOException {
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
