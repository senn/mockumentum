package com.senn.mockumentum.common;

import com.documentum.fc.common.IDfAttr;

public class MctmAttr implements IDfAttr {

    private final String name;
    private final int length;
    private final int dataType;
    private final boolean repeating;

    public MctmAttr(String name, int length, int dataType, boolean repeating) {
        this.name = name;
        this.length = length;
        this.dataType = dataType;
        this.repeating = repeating;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDataType() {
        return dataType;
    }

    @Override
    public boolean isRepeating() {
        return repeating;
    }

    @Override
    public int getAllowedLength(String s) {
        return Integer.MAX_VALUE; //unsupported
    }

    @Override
    public String getId() {
        return hashCode() + ""; //unsupported so using a unique replacement
    }

    @Override
    public boolean isQualifiable() {
        return true; //unsupported, so always true
    }
}
