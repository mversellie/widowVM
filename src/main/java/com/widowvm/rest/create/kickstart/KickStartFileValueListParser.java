package com.widowvm.rest.create.kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class KickStartFileValueListParser {

    public static ArrayList<String> listKickStartContent(String content) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(content));
        String currentLine = reader.readLine();
        ArrayList<String> lineList = new ArrayList();

        while(currentLine != null){

            if(currentLine.length() < 1 || currentLine.charAt(0) == '#'){
                currentLine = reader.readLine();
                continue;
            }

            lineList.add(currentLine);
            currentLine = reader.readLine();
        }


        return lineList;
    }
}
