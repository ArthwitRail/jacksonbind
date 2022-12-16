package org.bluetree;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("type2")
public class Type2StructureItem extends StructureItem {

    private String type2field;

    public Type2StructureItem(String name, String type, List<StructureItem> children, String type2field) {
        super(name,type,children);
        setType2field(type2field);
    }

    public Type2StructureItem() {
        super();
    }

    public String getType2field() {
        return type2field;
    }

    public void setType2field(String type2field) {
        this.type2field = type2field;
    }
}
