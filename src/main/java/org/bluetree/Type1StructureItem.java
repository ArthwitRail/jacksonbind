package org.bluetree;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("type1")
public class Type1StructureItem extends StructureItem {

    private String type1field;

    public Type1StructureItem(String name, String type, List<StructureItem> children, String type1field) {
        super(name,type,children);
        setType1field(type1field);
    }

    public Type1StructureItem() {
        super();
    }

    public String getType1field() {
        return type1field;
    }

    public void setType1field(String type1field) {
        this.type1field = type1field;
    }
}
