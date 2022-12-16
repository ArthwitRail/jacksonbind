package org.bluetree;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CreateJson {

    public static void main(String[] args) {

        try {


            ObjectMapper objectMapper = new ObjectMapper();

            Path rp = Paths.get("src", "test", "resources");
            String absPath = rp.toFile().getAbsolutePath();

            String outName = absPath + File.separator + args[0];

            Structure s = new Structure(args[1], args[2], null);

            int width = Integer.parseInt(args[3]);
            int depth = Integer.parseInt(args[4]);

            s.setChildren(createChildren(width, depth));

            objectMapper.writeValue(new File(outName), s);

        } catch (IOException ioe) {
            System.out.println("ioe: " + ioe);

        }
    }

    private static int childNo = 0;

    public static List<StructureItem> createChildren(int width, int depth) {

        ArrayList<StructureItem> children = null;
        if (depth > 0) {
            children = new ArrayList<>(width);

            for (int i=0;i<width;i++) {
                childNo++;
                StructureItem child = new StructureItem("child_"+depth+"_"+i+"_" + childNo, createChildren(width, depth - 1));
                System.out.println("Created child " + child.getName());
                children.add(child);
            }
        }
        return children;
    }
}
