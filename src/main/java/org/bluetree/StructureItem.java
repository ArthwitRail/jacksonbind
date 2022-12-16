package org.bluetree;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property="type", visible = true)

@JsonSubTypes({
        @JsonSubTypes.Type(value = Type0StructureItem.class, name="type0"),
        @JsonSubTypes.Type(value = Type1StructureItem.class, name="type1"),
        @JsonSubTypes.Type(value = Type2StructureItem.class, name="type2"),
})

public class StructureItem {

    @JsonProperty("children")
    List<StructureItem> children;

    @JsonProperty("name)")
    String name;

    @JsonProperty("type")
    String type;


    public StructureItem() {

    }

    public StructureItem(String name, String type, List<StructureItem> children) {
      setName(name);
      setType(type);
      setChildren(children);
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

