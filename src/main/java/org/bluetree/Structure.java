package org.bluetree;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Structure {

    String name;
    String type;
    List<StructureItem> children;


    public Structure(@JsonProperty("name") String name,
                     @JsonProperty("type") String type,
                     @JsonProperty("children") List<StructureItem> children) {
        setName(name);
        setType(type);
        setChildren(children);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<StructureItem> getChildren() {
        return children;
    }

    public void setChildren(List<StructureItem> children) {
        this.children = children;
    }
}
