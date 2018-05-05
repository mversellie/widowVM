package com.widowvm.rest.status;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;

public class VirshOutputParser {

    private HashMap<String, String> attributeMap;

    public VirshOutputParser(String virshOutput) throws IOException {
        attributeMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new StringReader(virshOutput));
        String currentLine = reader.readLine();

        while(currentLine != null){
            String keyAndValue[] =  currentLine.split("\\:");
            String key = keyAndValue[0];
            String value = formatValue(keyAndValue[1]);

            attributeMap.put(key,value);

            currentLine = reader.readLine();
        }

    }

    public HashMap<String,String> getAttributeMap() {
        return attributeMap;
    }

    public String formatValue(String unformattedValue){
        String valueSplitOnWhiteSpace[] = unformattedValue.split("\\s");
        StringBuilder value = new StringBuilder("");

        for(String valueSection:valueSplitOnWhiteSpace){
            if(!valueSection.isEmpty()) {
                value.append(valueSection + " ");
            }
        }

        return value.toString().substring(0,value.length() -1 );
    }
}
