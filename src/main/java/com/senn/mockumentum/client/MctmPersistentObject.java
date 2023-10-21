package com.senn.mockumentum.client;

import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.client.IDfPersistentObject;
import com.documentum.fc.client.IDfRelation;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.client.IDfType;
import com.documentum.fc.client.IDfValidator;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.IDfId;
import com.documentum.fc.common.IDfList;
import com.senn.mockumentum.internal.ObjectIdRegistry;

/**
 * Mockumentum implementation of {@link IDfPersistentObject}.
 * Not all functionality is exactly the same as in Documentum.
 *
 * @author Bart Thierens
 */
public class MctmPersistentObject extends MctmTypedObject implements IDfPersistentObject {

    private static final String ATTR_I_IS_DELETED = "i_is_deleted";

    private boolean isDirty = false;
    private boolean isNew = true;

    public MctmPersistentObject(IDfSession session, ObjectIdRegistry.ObjectType objectType) throws DfException {
        super(session, objectType);
        setBoolean(ATTR_I_IS_DELETED, false);
    }

    @Override
    public boolean isDeleted() throws DfException {
        return getBoolean(ATTR_I_IS_DELETED);
    }

    @Override
    public boolean isDirty() throws DfException {
        return isDirty;
    }

    @Override
    public boolean isNew() throws DfException {
        return isNew;
    }

    @Override
    public boolean isReplica() throws DfException {
        return false; //unsupported
    }

    @Override
    public IDfType getType() throws DfException {
        return null;
    }

    @Override
    public boolean isInstanceOf(String s) throws DfException {
        return false;
    }

    @Override
    public int getVStamp() throws DfException {
        return 0;
    }

    @Override
    public IDfValidator getValidator() throws DfException {
        return null;
    }

    @Override
    public boolean fetch(String s) throws DfException {
        return false;
    }

    @Override
    public boolean fetchWithCaching(String s, boolean b, boolean b1) throws DfException {
        return false;
    }

    @Override
    public void save() throws DfException {
        isNew = false;
        isDirty = false;
    }

    @Override
    public void revert() throws DfException {

    }

    @Override
    public void destroy() throws DfException {

    }

    @Override
    public void lock() throws DfException {

    }

    @Override
    public void lockEx(boolean b) throws DfException {

    }

    @Override
    public void signoff(String s, String s1, String s2) throws DfException {

    }

    @Override
    public IDfRelation addChildRelative(String s, IDfId iDfId, String s1, boolean b, String s2) throws DfException {
        return null;
    }

    @Override
    public IDfRelation addParentRelative(String s, IDfId iDfId, String s1, boolean b, String s2) throws DfException {
        return null;
    }

    @Override
    public IDfCollection getChildRelatives(String s) throws DfException {
        return null;
    }

    @Override
    public IDfCollection getParentRelatives(String s) throws DfException {
        return null;
    }

    @Override
    public void removeChildRelative(String s, IDfId iDfId, String s1) throws DfException {

    }

    @Override
    public void removeParentRelative(String s, IDfId iDfId, String s1) throws DfException {

    }

    @Override
    public String apiGet(String s, String s1) throws DfException {
        return null;
    }

    @Override
    public boolean apiSet(String s, String s1, String s2) throws DfException {
        return false;
    }

    @Override
    public boolean apiExec(String s, String s1) throws DfException {
        return false;
    }

    @Override
    public IDfList getAttrAssistance(String s) throws DfException {
        return null;
    }

    @Override
    public IDfList getAttrAssistanceWithValues(String s, IDfList iDfList, IDfList iDfList1) throws DfException {
        return null;
    }

    @Override
    public IDfList getAttrAsstDependencies(String s) throws DfException {
        return null;
    }

    @Override
    public String getWidgetType(int i, String s) throws DfException {
        return null;
    }

    @Override
    public void validateAllRules(int i) throws DfException {

    }

    @Override
    public void validateAttrRules(String s, int i) throws DfException {

    }

    @Override
    public void validateAttrRulesWithValue(String s, String s1, int i) throws DfException {

    }

    @Override
    public void validateAttrRulesWithValues(String s, IDfList iDfList, int i) throws DfException {

    }

    @Override
    public void validateObjRules(int i) throws DfException {

    }

    @Override
    public void validateObjRulesWithValues(IDfList iDfList, IDfList iDfList1, int i) throws DfException {

    }

    @Override
    public void setPartition(int i) throws DfException {

    }

    @Override
    public int getPartition() throws DfException {
        return 0;
    }

    @Override
    public void registerEvent(String s, String s1, int i, boolean b) throws DfException {

    }

    @Override
    public void unRegisterEvent(String s) throws DfException {

    }

    @Override
    public void unRegisterEventEx(String s, String s1) throws DfException {

    }
}
