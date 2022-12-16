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

            outName = absPath + File.separator + "si_" + args[0];
            objectMapper.writeValue(new File(outName), new Type0StructureItem("namefield", "type0", null, "fielddatsa"));

        } catch (IOException ioe) {
            System.out.println("ioe: " + ioe);

        }
    }

    private static int childNo = 0;

    private static StructureItem  createStructureItem(String name, String type, int width, int depth) {
        if ("type0".equals(type))
            return new Type0StructureItem(name, type, createChildren(width,depth), "type0field_"+(width*depth));
        else if ("type1".equals(type))
            return new Type1StructureItem(name, type, createChildren(width,depth), "type1field_"+(width*depth));
        else
            return new Type2StructureItem(name, type, createChildren(width,depth), "type2field_"+(width*depth));
    }

    public static List<StructureItem> createChildren(int width, int depth) {

        ArrayList<StructureItem> children = null;
        if (depth > 0) {
            children = new ArrayList<>(width);

            for (int i=0;i<width;i++) {
                childNo++;
                String name = "child_"+depth+"_"+i+"_" + childNo;
                String type = "type"+(i%3);

                StructureItem child  = createStructureItem(name, type, width, depth-1);
            //    StructureItem child = new StructureItem("child_"+depth+"_"+i+"_" + childNo, "type"+(i%3), createChildren(width, depth - 1));
                System.out.println("Created child " + child.getName());
                children.add(child);
            }
        }
        return children;
    }
}
