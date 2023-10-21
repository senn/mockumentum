package com.senn.mockumentum.internal;

import com.documentum.fc.common.IDfValue;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link LinkedList} wrapper that holds a dataType associated with an attribute
 *
 * @author Bart Thierens
 */
public class LinkedValueList extends LinkedList<IDfValue> {

    private final int dataType;

    public LinkedValueList(int dataType) {
        super();
        this.dataType = dataType;
    }

    public static LinkedValueList empty() {
        return new LinkedValueList(IDfValue.DF_UNDEFINED);
    }

    public LinkedValueList(int dataType, Collection<IDfValue> collection) {
        super(collection);
        this.dataType = dataType;
    }

    public int getDataType() {
        return dataType;
    }

    @Override
    public LinkedValueList subList(int fromIndex, int toIndex) {
        return new LinkedValueList(dataType, super.subList(fromIndex, toIndex));
    }
}
