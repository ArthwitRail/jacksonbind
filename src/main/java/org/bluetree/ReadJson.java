package org.bluetree;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadJson {
    public static void main(String[] args) {

        try {

            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            Path rp = Paths.get("src", "test", "resources");
            String absPath = rp.toFile().getAbsolutePath();

            Structure s = objectMapper.readValue(new File(absPath+File.separator+"myfile1.json"), Structure.class);

            System.out.println(s);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Hello world!");
    }
}