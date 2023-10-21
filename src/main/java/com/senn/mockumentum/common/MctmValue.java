package com.senn.mockumentum.common;

import com.documentum.fc.common.DfException;
import com.documentum.fc.common.IDfId;
import com.documentum.fc.common.IDfTime;
import com.documentum.fc.common.IDfValue;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class MctmValue implements IDfValue {

    private final Object value;
    private final int dataType;

    public MctmValue(Object value, int dataType) {
        this.value = value;
        this.dataType = dataType;
    }

    @Override
    public String asString() {
        if (value == null) {
            return null;
        } else if (DF_STRING == dataType && value instanceof String) {
            return (String) value;
        }
        return value.toString();
    }

    @Override
    public int asInteger() {
        if (DF_INTEGER == dataType && value instanceof Integer) {
            return (Integer) value;
        }
        return NumberUtils.toInt(asString(), 0);
    }

    @Override
    public boolean asBoolean() {
        if (DF_BOOLEAN == dataType && value instanceof Boolean) {
            return (Boolean) value;
        }
        return BooleanUtils.toBoolean(asString());
    }

    @Override
    public double asDouble() {
        if (DF_DOUBLE == dataType && value instanceof Double) {
            return (Double) value;
        }
        return NumberUtils.toDouble(asString(), 0);
    }

    @Override
    public IDfTime asTime() {
        if (value instanceof IDfTime) {
            return (IDfTime) value;
        }
        throw new IllegalArgumentException("Not a TIME");
    }

    @Override
    public IDfId asId() {
        if (value instanceof IDfId) {
            return (IDfId) value;
        }
        throw new IllegalArgumentException("Not an ID");
    }

    @Override
    public int getDataType() {
        return dataType;
    }

    @Override
    public int compareTo(IDfValue iDfValue) throws DfException {
        if (iDfValue == null) {
            return 1;
        }
        try {
            return iDfValue.asString().compareTo(asString());
        } catch (Exception e) {
            throw new MctmException(e);
        }
    }

    @Override
    public String toString() {
        return asString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof IDfValue)) {
            return false;
        }
        IDfValue val = (IDfValue) obj;
        return val.getDataType() == getDataType() && asString().equals(val.asString());
    }

}
