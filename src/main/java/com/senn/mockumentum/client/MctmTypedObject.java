package com.senn.mockumentum.client;

import com.documentum.fc.client.IDfSession;
import com.documentum.fc.client.IDfSessionManager;
import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.DfId;
import com.documentum.fc.common.DfTime;
import com.documentum.fc.common.IDfAttr;
import com.documentum.fc.common.IDfId;
import com.documentum.fc.common.IDfTime;
import com.documentum.fc.common.IDfValue;
import com.senn.mockumentum.common.MctmAttr;
import com.senn.mockumentum.common.MctmException;
import com.senn.mockumentum.common.MctmValue;
import com.senn.mockumentum.internal.LinkedValueList;
import com.senn.mockumentum.internal.ObjectIdRegistry;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mockumentum implementation of {@link IDfTypedObject}.
 * Not all functionality is exactly the same as in Documentum.
 * The attribute mechanism is backed by {@link LinkedHashMap}s and {@link LinkedValueList}s.
 *
 * @author Bart Thierens
 */
public class MctmTypedObject implements IDfTypedObject {

    private final LinkedHashMap<String, LinkedValueList> properties = new LinkedHashMap<>();
    private final LinkedHashMap<String, Boolean> propertyIsRepeating = new LinkedHashMap<>();
    private final List<String> propertyNames = new LinkedList<>();

    private final IDfSession session;
    private final IDfId objectId;

    public MctmTypedObject(IDfSession session, ObjectIdRegistry.ObjectType objectType) throws DfException {
        this.session = session;
        objectId = DfId.valueOf(ObjectIdRegistry.generateObjectId(objectType));
    }

    @Override
    public void appendBoolean(String s, boolean b) throws DfException {
        appendValue(s, new MctmValue(b, IDfValue.DF_BOOLEAN));
    }

    @Override
    public void appendDouble(String s, double v) throws DfException {
        appendValue(s, new MctmValue(v, IDfValue.DF_DOUBLE));
    }

    @Override
    public void appendId(String s, IDfId iDfId) throws DfException {
        appendValue(s, new MctmValue(iDfId, IDfValue.DF_ID));
    }

    @Override
    public void appendInt(String s, int i) throws DfException {
        appendValue(s, new MctmValue(i, IDfValue.DF_INTEGER));
    }

    @Override
    public void appendString(String s, String s1) throws DfException {
        appendValue(s, new MctmValue(s, IDfValue.DF_STRING));
    }

    @Override
    public void appendTime(String s, IDfTime iDfTime) throws DfException {
        appendValue(s, new MctmValue(iDfTime, IDfValue.DF_TIME));
    }

    @Override
    public void appendValue(String s, IDfValue iDfValue) throws DfException {
        properties.computeIfAbsent(s, key -> new LinkedValueList(iDfValue.getDataType())).add(iDfValue);
    }

    @Override
    public String dump() throws DfException {
        return properties.toString(); //todo: actual format
    }

    @Override
    public Enumeration<?> enumAttrs() throws DfException {
        return Collections.enumeration(properties.keySet());
    }

    @Override
    public int findAttrIndex(String s) throws DfException {
        return propertyNames.indexOf(s);
    }

    @Override
    public int findBoolean(String s, boolean b) throws DfException {
        return findValue(s, new MctmValue(b, IDfValue.DF_BOOLEAN));
    }

    @Override
    public int findDouble(String s, double v) throws DfException {
        return findValue(s, new MctmValue(v, IDfValue.DF_DOUBLE));
    }

    @Override
    public int findId(String s, IDfId iDfId) throws DfException {
        return findValue(s, new MctmValue(iDfId, IDfValue.DF_ID));
    }

    @Override
    public int findInt(String s, int i) throws DfException {
        return findValue(s, new MctmValue(i, IDfValue.DF_INTEGER));
    }

    @Override
    public int findString(String s, String s1) throws DfException {
        return findValue(s, new MctmValue(s1, IDfValue.DF_STRING));
    }

    @Override
    public int findTime(String s, IDfTime iDfTime) throws DfException {
        return findValue(s, new MctmValue(iDfTime, IDfValue.DF_TIME));
    }

    @Override
    public int findValue(String s, IDfValue iDfValue) throws DfException {
        return properties.computeIfAbsent(s, key -> new LinkedValueList(iDfValue.getDataType())).indexOf(iDfValue);
    }

    @Override
    public String getAllRepeatingStrings(String s, String s1) throws DfException {
        List<IDfValue> values = properties.getOrDefault(s, LinkedValueList.empty());
        if (values.isEmpty()) {
            return "";
        }
        return values.stream()
                .map(x -> x == null ? "" : x.toString())
                .collect(Collectors.joining(s1));
    }

    @Override
    public IDfAttr getAttr(int i) throws DfException {
        try {
            String name = propertyNames.get(i);
            return new MctmAttr(name, properties.getOrDefault(name, LinkedValueList.empty()).size(), getAttrDataType(name), propertyIsRepeating.get(name));
        } catch (DfException de) {
            throw de;
        } catch (Exception e) {
            throw new MctmException(e);
        }
    }

    @Override
    public int getAttrCount() throws DfException {
        return properties.keySet().size();
    }

    @Override
    public int getAttrDataType(String s) throws DfException {
        return properties.getOrDefault(s, LinkedValueList.empty()).getDataType();
    }

    @Override
    public boolean getBoolean(String s) throws DfException {
        return getRepeatingBoolean(s, 0);
    }

    @Override
    public double getDouble(String s) throws DfException {
        return getRepeatingDouble(s, 0);
    }

    @Override
    public IDfId getId(String s) throws DfException {
        return getRepeatingId(s, 0);
    }

    @Override
    public int getInt(String s) throws DfException {
        return getRepeatingInt(s, 0);
    }

    @Override
    public long getLong(String s) throws DfException {
        return getRepeatingLong(s, 0);
    }

    @Override
    public IDfId getObjectId() throws DfException {
        return objectId;
    }

    @Override
    public boolean getRepeatingBoolean(String s, int i) throws DfException {
        if (IDfValue.DF_BOOLEAN != getAttrDataType(s)) {
            throw new MctmException("Value is not BOOLEAN");
        }
        List<IDfValue> values = properties.get(s);
        if (values != null && !values.isEmpty()) {
            return values.get(i).asBoolean();
        }
        return false;
    }

    @Override
    public double getRepeatingDouble(String s, int i) throws DfException {
        if (IDfValue.DF_DOUBLE != getAttrDataType(s)) {
            throw new MctmException("Value is not DOUBLE");
        }
        List<IDfValue> values = properties.get(s);
        if (values != null && !values.isEmpty()) {
            return values.get(i).asDouble();
        }
        return 0;
    }

    @Override
    public IDfId getRepeatingId(String s, int i) throws DfException {
        if (IDfValue.DF_ID != getAttrDataType(s)) {
            throw new MctmException("Value is not ID");
        }
        List<IDfValue> values = properties.get(s);
        if (values != null && !values.isEmpty()) {
            return values.get(i).asId();
        }
        return DfId.DF_NULLID;
    }

    @Override
    public int getRepeatingInt(String s, int i) throws DfException {
        if (IDfValue.DF_INTEGER != getAttrDataType(s)) {
            throw new MctmException("Value is not INTEGER");
        }
        List<IDfValue> values = properties.get(s);
        if (values != null && !values.isEmpty()) {
            return values.get(i).asInteger();
        }
        return 0;
    }

    @Override
    public long getRepeatingLong(String s, int i) throws DfException {
        if (IDfValue.DF_DOUBLE != getAttrDataType(s) || IDfValue.DF_INTEGER != getAttrDataType(s)) {
            throw new MctmException("Value is not LONG");
        }
        List<IDfValue> values = properties.get(s);
        if (values != null && !values.isEmpty()) {
            return (long) values.get(i).asDouble();
        }
        return 0L;
    }

    @Override
    public String getRepeatingString(String s, int i) throws DfException {
        if (IDfValue.DF_STRING != getAttrDataType(s)) {
            throw new MctmException("Value is not STRING");
        }
        List<IDfValue> values = properties.get(s);
        if (values != null && !values.isEmpty()) {
            return values.get(i).asString();
        }
        return null;
    }

    @Override
    public IDfTime getRepeatingTime(String s, int i) throws DfException {
        if (IDfValue.DF_TIME != getAttrDataType(s)) {
            throw new MctmException("Value is not TIME");
        }
        List<IDfValue> values = properties.get(s);
        if (values != null && !values.isEmpty()) {
            return values.get(i).asTime();
        }
        return DfTime.DF_NULLDATE;
    }

    @Override
    public IDfValue getRepeatingValue(String s, int i) throws DfException {
        List<IDfValue> values = properties.get(s);
        if (values != null && !values.isEmpty()) {
            return values.get(i);
        }
        return null; //is correct?
    }

    @Override
    public IDfSession getObjectSession() {
        return session;
    }

    @Override
    public IDfSession getOriginalSession() {
        return session;
    }

    @Override
    public IDfSession getSession() {
        return session;
    }

    @Override
    public IDfSessionManager getSessionManager() {
        return session.getSessionManager();
    }

    @Override
    public String getString(String s) throws DfException {
        return getRepeatingString(s, 0);
    }

    @Override
    public IDfTime getTime(String s) throws DfException {
        return getRepeatingTime(s, 0);
    }

    @Override
    public IDfValue getValue(String s) throws DfException {
        return getRepeatingValue(s, 0);
    }

    @Override
    public IDfValue getValueAt(int i) {
        return null; //what does this do again????
    }

    @Override
    public int getValueCount(String s) {
        return properties.getOrDefault(s, LinkedValueList.empty()).size();
    }

    @Override
    public boolean hasAttr(String s) {
        return propertyNames.contains(s);
    }

    @Override
    public void insertBoolean(String s, int i, boolean b) throws DfException {
        insertValue(s, i, new MctmValue(b, IDfValue.DF_BOOLEAN));
    }

    @Override
    public void insertDouble(String s, int i, double v) throws DfException {
        insertValue(s, i, new MctmValue(v, IDfValue.DF_DOUBLE));
    }

    @Override
    public void insertId(String s, int i, IDfId iDfId) throws DfException {
        insertValue(s, i, new MctmValue(iDfId, IDfValue.DF_ID));
    }

    @Override
    public void insertInt(String s, int i, int i1) throws DfException {
        insertValue(s, i, new MctmValue(i1, IDfValue.DF_INTEGER));
    }

    @Override
    public void insertString(String s, int i, String s1) throws DfException {
        insertValue(s, i, new MctmValue(s1, IDfValue.DF_STRING));
    }

    @Override
    public void insertTime(String s, int i, IDfTime iDfTime) throws DfException {
        insertValue(s, i, new MctmValue(iDfTime, IDfValue.DF_TIME));
    }

    @Override
    public void insertValue(String s, int i, IDfValue iDfValue) throws DfException {
        try {
            //hacky way of inserting into a linkedlist
            LinkedValueList existingValues = properties.getOrDefault(s, new LinkedValueList(iDfValue.getDataType()));
            LinkedValueList preInsert = existingValues.subList(0, i - 1);
            LinkedValueList postInsert = existingValues.subList(i, existingValues.size());
            LinkedValueList newValues = new LinkedValueList(existingValues.getDataType(), preInsert);
            newValues.add(iDfValue);
            newValues.addAll(postInsert);
            properties.put(s, newValues);
        } catch (Exception e) {
            throw new MctmException(e);
        }
    }

    @Override
    public boolean isAttrRepeating(String s) throws DfException {
        return propertyIsRepeating.get(s);
    }

    @Override
    public boolean isNull(String s) throws DfException {
        return properties.containsKey(s);
    }

    @Override
    public void remove(String s, int i) throws DfException {
        try {
            properties.get(s).remove(i);
        } catch (Exception e) {
            throw new MctmException(e);
        }
    }

    @Override
    public void removeAll(String s) throws DfException {
        properties.remove(s);
        propertyNames.remove(s);
        propertyIsRepeating.remove(s);
    }

    @Override
    public void setBoolean(String s, boolean b) throws DfException {
        setRepeatingBoolean(s, 0, b);
    }

    @Override
    public void setDouble(String s, double v) throws DfException {
        setRepeatingDouble(s, 0, v);
    }

    @Override
    public void setId(String s, IDfId iDfId) throws DfException {
        setRepeatingId(s, 0, iDfId);
    }

    @Override
    public void setInt(String s, int i) throws DfException {
        setRepeatingInt(s, 0, i);
    }

    @Override
    public void setNull(String s) throws DfException {
        properties.put(s, null);
    }

    @Override
    public void setRepeatingBoolean(String s, int i, boolean b) throws DfException {
        setRepeatingValue(s, i, new MctmValue(b, IDfValue.DF_BOOLEAN));
    }

    @Override
    public void setRepeatingDouble(String s, int i, double v) throws DfException {
        setRepeatingValue(s, i, new MctmValue(v, IDfValue.DF_DOUBLE));
    }

    @Override
    public void setRepeatingId(String s, int i, IDfId iDfId) throws DfException {
        setRepeatingValue(s, i, new MctmValue(iDfId, IDfValue.DF_ID));
    }

    @Override
    public void setRepeatingInt(String s, int i, int i1) throws DfException {
        setRepeatingValue(s, i, new MctmValue(i1, IDfValue.DF_INTEGER));
    }

    @Override
    public void setRepeatingString(String s, int i, String s1) throws DfException {
        setRepeatingValue(s, i, new MctmValue(s1, IDfValue.DF_STRING));
    }

    @Override
    public void setRepeatingTime(String s, int i, IDfTime iDfTime) throws DfException {
        setRepeatingValue(s, i, new MctmValue(iDfTime, IDfValue.DF_TIME));
    }

    @Override
    public void setRepeatingValue(String s, int i, IDfValue iDfValue) throws DfException {
        try {
            LinkedValueList values = properties.computeIfAbsent(s, key -> new LinkedValueList(iDfValue.getDataType()));
            if (values.size() == i) {
                values.add(iDfValue);
            } else {
                values.set(i, iDfValue);
            }
        } catch (Exception e) {
            throw new MctmException(e);
        }
    }

    @Override
    public void setSessionManager(IDfSessionManager iDfSessionManager) {
        throw new UnsupportedOperationException("Unsupported in Mockumentum");
    }

    @Override
    public void setString(String s, String s1) throws DfException {
        setRepeatingString(s, 0, s1);
    }

    @Override
    public void setTime(String s, IDfTime iDfTime) throws DfException {
        setRepeatingTime(s, 0, iDfTime);
    }

    @Override
    public void setValue(String s, IDfValue iDfValue) throws DfException {
        setRepeatingValue(s, 0, iDfValue);
    }

    @Override
    public void truncate(String s, int i) throws DfException {
        try {
            LinkedValueList values = properties.get(s);
            values.subList(0, i);
           properties.put(s, values);
        } catch (Exception e) {
            throw new MctmException(e);
        }
    }
}
