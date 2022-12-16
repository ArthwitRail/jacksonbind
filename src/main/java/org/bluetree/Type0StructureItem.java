package org.bluetree;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("type0")
public class Type0StructureItem extends StructureItem {

    private String type0field;

    public String getType0field() {
        return type0field;
    }

    public void setType0field(String type0field) {
        this.type0field = type0field;
    }

    public Type0StructureItem(String name, String type, List<StructureItem> children, String type0field) {
        super(name,type,children);
        setType0field(type0field);
    }

    public Type0StructureItem() {
        super();
    }


}
