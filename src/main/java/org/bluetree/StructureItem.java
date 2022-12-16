package org.bluetree;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StructureItem {

    List<StructureItem> children;

    String name;

    public StructureItem(@JsonProperty("name") String name, @JsonProperty("children") List<StructureItem> children) {
        setChildren(children);
        setName(name);
    }

    public List<StructureItem> getChildren() {
        return children;
    }

    public void setChildren(List<StructureItem> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

