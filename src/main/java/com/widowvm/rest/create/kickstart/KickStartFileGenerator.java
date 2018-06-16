package com.widowvm.rest.create.kickstart;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class KickStartFileGenerator {

    public static final String INVALIDFILERESPONSE="INVALID";

    public static String generateKickStartFile(String fileContents){
        String kickStartFileDirectory = "kickstart";

            String fileName = "";

            for(int i = 0;i < 3 ; i++) {
                try {
                    fileName = kickStartFileDirectory + "/" + generateRandomFilename() + ".ks";
                    FileUtils.writeStringToFile(new File(fileName), fileContents);
                    break;
                }
                catch(IOException exception){
                    exception.printStackTrace();
                }
            }

            return fileName;

    }

    private static String generateRandomFilename() {
        StringBuilder filename = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 18; i++) {
            int character = (char) (random.nextInt(122 - 97) + 97);
            filename.append(character);
        }
        return filename.toString();
    }


    public static String getFilenameFromPath(String filepath) {
        String[] subStrings = filepath.split("/");
        return subStrings[subStrings.length -1];
    }
}
