package com.senn.mockumentum.client;

import com.documentum.fc.client.DfDborNotFoundException;
import com.documentum.fc.client.DfServiceNotFoundException;
import com.documentum.fc.client.DormantStatus;
import com.documentum.fc.client.IDfACL;
import com.documentum.fc.client.IDfAuditTrailManager;
import com.documentum.fc.client.IDfBatchManager;
import com.documentum.fc.client.IDfClient;
import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.client.IDfEnumeration;
import com.documentum.fc.client.IDfEventManager;
import com.documentum.fc.client.IDfFolder;
import com.documentum.fc.client.IDfFormat;
import com.documentum.fc.client.IDfGetObjectOptions;
import com.documentum.fc.client.IDfGroup;
import com.documentum.fc.client.IDfLocalModuleRegistry;
import com.documentum.fc.client.IDfLocalTransaction;
import com.documentum.fc.client.IDfObjectPathsMap;
import com.documentum.fc.client.IDfPersistentObject;
import com.documentum.fc.client.IDfRelationType;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.client.IDfSessionManager;
import com.documentum.fc.client.IDfSessionScopeManager;
import com.documentum.fc.client.IDfType;
import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.client.IDfUser;
import com.documentum.fc.client.IDfVersionTreeLabels;
import com.documentum.fc.client.IDfWorkflowBuilder;
import com.documentum.fc.client.acs.IDfAcsTransferPreferences;
import com.documentum.fc.client.fulltext.IDfFtConfig;
import com.documentum.fc.client.mq.IDfMessageQueueManager;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.IDfId;
import com.documentum.fc.common.IDfList;
import com.documentum.fc.common.IDfLoginInfo;
import com.documentum.fc.common.IDfTime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Mockumentum implementation of {@link IDfSession}.
 * Not all functionality available in Documentum is provided.
 *
 * @author Bart Thierens
 */
public class MctmSession implements IDfSession {

    private final String userName;

    private boolean connected;

    private MctmSession(String userName) {
        this.userName = userName;
        this.connected = true;
    }

    public static MctmSession create(String userName) {
        return new MctmSession(userName);
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public boolean isShared() throws DfException {
        return false; //not implemented yet
    }

    @Override
    public void disconnect() throws DfException {
        this.connected = false;
    }

    @Override
    public boolean isTransactionActive() throws DfException {
        return false; //not implemented yet
    }

    @Override
    public void beginTrans() throws DfException {
        //not implemented yet
    }

    @Override
    public void abortTrans() throws DfException {
        //not implemented yet
    }

    @Override
    public void commitTrans() throws DfException {
        //not implemented yet
    }

    @Override
    public IDfLocalTransaction beginTransEx() throws DfException {
        //not implemented yet
        return null;
    }

    @Override
    public void commitTransEx(IDfLocalTransaction iDfLocalTransaction) throws DfException {
        //not implemented yet
    }

    @Override
    public void abortTransEx(IDfLocalTransaction iDfLocalTransaction) throws DfException {
        //not implemented yet
    }

    @Override
    public IDfBatchManager getBatchManager() {
        //not implemented yet
        return null;
    }

    @Override
    public void authenticate(IDfLoginInfo iDfLoginInfo) throws DfException {
        //not implemented yet
    }

    @Override
    public IDfSessionManager getSessionManager() {
        return null;
    }

    @Override
    public IDfTypedObject getSessionConfig() throws DfException {
        return null;
    }

    @Override
    public IDfTypedObject getConnectionConfig() throws DfException {
        return null;
    }

    @Override
    public IDfTypedObject getDocbaseConfig() throws DfException {
        return null;
    }

    @Override
    public IDfTypedObject getServerConfig() throws DfException {
        return null;
    }

    @Override
    public String getSessionId() throws DfException {
        return null;
    }

    @Override
    public IDfLoginInfo getLoginInfo() throws DfException {
        return null;
    }

    @Override
    public IDfSession getRelatedSession(String s) throws DfException {
        return null;
    }

    @Override
    public IDfSession getRelatedSession(IDfId iDfId) throws DfException {
        return null;
    }

    @Override
    public String getLoginUserName() throws DfException {
        return null;
    }

    @Override
    public String getDocbaseId() throws DfException {
        return null;
    }

    @Override
    public String getDocbaseName() throws DfException {
        return null;
    }

    @Override
    public String getServerVersion() throws DfException {
        return null;
    }

    @Override
    public String getDocbaseOwnerName() throws DfException {
        return null;
    }

    @Override
    public String getDBMSName() throws DfException {
        return null;
    }

    @Override
    public String getSecurityMode() throws DfException {
        return null;
    }

    @Override
    public int getDefaultACL() throws DfException {
        return 0;
    }

    @Override
    public boolean isACLDocbase() throws DfException {
        return false;
    }

    @Override
    public IDfPersistentObject getObject(IDfId iDfId) throws DfException {
        return null;
    }

    @Override
    public IDfPersistentObject getObjectWithOptions(IDfId iDfId, IDfGetObjectOptions iDfGetObjectOptions) throws DfException {
        return null;
    }

    @Override
    public IDfPersistentObject newObject(String s) throws DfException {
        return null;
    }

    @Override
    public IDfPersistentObject newLightObject(String s, IDfId iDfId) throws DfException {
        return null;
    }

    @Override
    public IDfPersistentObject getObjectWithCaching(IDfId iDfId, String s, String s1, String s2, boolean b, boolean b1) throws DfException {
        return null;
    }

    @Override
    public IDfId getIdByQualification(String s) throws DfException {
        return null;
    }

    @Override
    public IDfPersistentObject getObjectByQualification(String s) throws DfException {
        return null;
    }

    @Override
    public IDfEnumeration getObjectsByQuery(String s, String s1) throws DfException {
        return null;
    }

    @Override
    public IDfPersistentObject getObjectByPath(String s) throws DfException {
        return null;
    }

    @Override
    public IDfFolder getFolderByPath(String s) throws DfException {
        return null;
    }

    @Override
    public IDfFolder getFolderBySpecification(String s) throws DfException {
        return null;
    }

    @Override
    public IDfPersistentObject newObjectWithType(String s, String s1) throws DfException {
        return null;
    }

    @Override
    public IDfPersistentObject getObjectWithType(IDfId iDfId, String s, String s1) throws DfException {
        return null;
    }

    @Override
    public IDfPersistentObject getObjectWithInterface(IDfId iDfId, String s) throws DfException, DfServiceNotFoundException, DfDborNotFoundException {
        return null;
    }

    @Override
    public IDfPersistentObject getObjectByQualificationWithInterface(String s, String s1) throws DfException, DfServiceNotFoundException {
        return null;
    }

    @Override
    public IDfPersistentObject getReplicaForMaster(IDfId iDfId) throws DfException {
        return null;
    }

    @Override
    public void flush(String s, String s1) throws DfException {

    }

    @Override
    public void flushEx(String s, String s1, boolean b, boolean b1) throws DfException {

    }

    @Override
    public void flushCache(boolean b) throws DfException {

    }

    @Override
    public void flushGlobalCache(String s) throws DfException {

    }

    @Override
    public IDfACL getACL(String s, String s1) throws DfException {
        return null;
    }

    @Override
    public IDfFormat getFormat(String s) throws DfException {
        return null;
    }

    @Override
    public IDfType getType(String s) throws DfException {
        return null;
    }

    @Override
    public IDfTypedObject getTypeDescription(String s, String s1, IDfId iDfId, String s2) throws DfException {
        return null;
    }

    @Override
    public IDfGroup getGroup(String s) throws DfException {
        return null;
    }

    @Override
    public IDfUser getUser(String s) throws DfException {
        return null;
    }

    @Override
    public IDfUser getUserByOSName(String s, String s1) throws DfException {
        return null;
    }

    @Override
    public IDfUser getUserByLoginName(String s, String s1) throws DfException {
        return null;
    }

    @Override
    public String getLoginTicket() throws DfException {
        return null;
    }

    @Override
    public String getLoginTicketEx(String s, String s1, int i, boolean b, String s2) throws DfException {
        return null;
    }

    @Override
    public String getLoginTicketForUser(String s) throws DfException {
        return null;
    }

    @Override
    public String getAliasSet() throws DfException {
        return null;
    }

    @Override
    public void setAliasSet(String s) throws DfException {

    }

    @Override
    public String resolveAlias(IDfId iDfId, String s) throws DfException {
        return null;
    }

    @Override
    public String getMessage(int i) throws DfException {
        return null;
    }

    @Override
    public IDfCollection getLastCollection() throws DfException {
        return null;
    }

    @Override
    public void setBatchHint(int i) throws DfException {

    }

    @Override
    public IDfCollection apply(String s, String s1, IDfList iDfList, IDfList iDfList1, IDfList iDfList2) throws DfException {
        return null;
    }

    @Override
    public String describe(String s, String s1) throws DfException {
        return null;
    }

    @Override
    public IDfId archive(String s, String s1, int i, boolean b, IDfTime iDfTime) throws DfException {
        return null;
    }

    @Override
    public IDfId restore(String s, String s1, String s2, int i, boolean b, IDfTime iDfTime) throws DfException {
        return null;
    }

    @Override
    public void changePassword(String s, String s1) throws DfException {

    }

    @Override
    public void purgeLocalFiles() throws DfException {

    }

    @Override
    public void reInit(String s) throws DfException {

    }

    @Override
    public void reInitEx(String s, boolean b) throws DfException {

    }

    @Override
    public void reStart(String s, boolean b) throws DfException {

    }

    @Override
    public void shutdown(boolean b, boolean b1) throws DfException {

    }

    @Override
    public void dequeue(IDfId iDfId) throws DfException {

    }

    @Override
    public void dequeueAll() throws DfException {

    }

    @Override
    public boolean hasEvents() throws DfException {
        return false;
    }

    @Override
    public IDfCollection getEvents() throws DfException {
        return null;
    }

    @Override
    public IDfCollection getTasks(String s, int i, String s1, String s2) throws DfException {
        return null;
    }

    @Override
    public IDfCollection getTasksEx(String s, int i, IDfList iDfList, IDfList iDfList1) throws DfException {
        return null;
    }

    @Override
    public IDfId sendToDistributionList(IDfList iDfList, IDfList iDfList1, String s, IDfList iDfList2, int i, boolean b) throws DfException {
        return null;
    }

    @Override
    public IDfId sendToDistributionListEx(IDfList iDfList, IDfList iDfList1, String s, IDfList iDfList2, int i, int i1) throws DfException {
        return null;
    }

    @Override
    public IDfCollection getRunnableProcesses(String s) throws DfException {
        return null;
    }

    @Override
    public IDfWorkflowBuilder newWorkflowBuilder(IDfId iDfId) throws DfException {
        return null;
    }

    @Override
    public IDfVersionTreeLabels getVersionTreeLabels(IDfId iDfId) throws DfException {
        return null;
    }

    @Override
    public IDfRelationType getRelationType(String s) throws DfException {
        return null;
    }

    @Override
    public IDfClient getClient() {
        return null;
    }

    @Override
    public IDfTypedObject getClientConfig() throws DfException {
        return null;
    }

    @Override
    public IDfTypedObject getDocbrokerMap() throws DfException {
        return null;
    }

    @Override
    public IDfTypedObject getServerMap(String s) throws DfException {
        return null;
    }

    @Override
    public IDfAuditTrailManager getAuditTrailManager() throws DfException {
        return null;
    }

    @Override
    public IDfEventManager getEventManager() throws DfException {
        return null;
    }

    @Override
    public String getDocbaseScope() throws DfException {
        return null;
    }

    @Override
    public String setDocbaseScope(String s) throws DfException {
        return null;
    }

    @Override
    public String setDocbaseScopeById(IDfId iDfId) throws DfException {
        return null;
    }

    @Override
    public boolean isAdopted() throws DfException {
        return false;
    }

    @Override
    public boolean isRemote() throws DfException {
        return false;
    }

    @Override
    public boolean lock(int i) {
        return false;
    }

    @Override
    public boolean unlock() {
        return false;
    }

    @Override
    public String getDMCLSessionId() throws DfException {
        return null;
    }

    @Override
    public void traceDMCL(int i, String s) throws DfException {

    }

    @Override
    public boolean isServerTraceOptionSet(String s) throws DfException {
        return false;
    }

    @Override
    public void setServerTraceLevel(int i, String s) throws DfException {

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
    public ByteArrayInputStream apiGetBytes(String s, String s1, String s2, String s3, int i) throws DfException {
        return null;
    }

    @Override
    public boolean apiSetBytes(String s, String s1, ByteArrayOutputStream byteArrayOutputStream) throws DfException {
        return false;
    }

    @Override
    public IDfList apiDesc(String s) throws DfException {
        return null;
    }

    @Override
    public boolean resetTicketKey() throws DfException {
        return false;
    }

    @Override
    public String exportTicketKey(String s) throws DfException {
        return null;
    }

    @Override
    public boolean importTicketKey(String s, String s1) throws DfException {
        return false;
    }

    @Override
    public void addDynamicGroup(String s) throws DfException {

    }

    @Override
    public void removeDynamicGroup(String s) throws DfException {

    }

    @Override
    public int getDynamicGroupCount() throws DfException {
        return 0;
    }

    @Override
    public String getDynamicGroup(int i) throws DfException {
        return null;
    }

    @Override
    public boolean resetPassword(String s) throws DfException {
        return false;
    }

    @Override
    public String getApplicationToken(String s, String s1, int i, String s2, boolean b) throws DfException {
        return null;
    }

    @Override
    public IDfLocalModuleRegistry getModuleRegistry() throws DfException {
        return null;
    }

    @Override
    public IDfEnumeration getObjectPaths(IDfId iDfId) throws DfException {
        return null;
    }

    @Override
    public IDfObjectPathsMap getObjectPaths(IDfList iDfList) throws DfException {
        return null;
    }

    @Override
    public void assume(IDfLoginInfo iDfLoginInfo) throws DfException {

    }

    @Override
    public IDfAcsTransferPreferences getAcsTransferPreferences() {
        return null;
    }

    @Override
    public void setAcsTransferPreferences(IDfAcsTransferPreferences iDfAcsTransferPreferences) {

    }

    @Override
    public boolean isRestricted() {
        return false;
    }

    @Override
    public boolean isDeadlockVictim() {
        return false;
    }

    @Override
    public void publishDataDictionary(String s, String s1, String s2, boolean b) throws DfException {

    }

    @Override
    public boolean isServerAuthenticated() {
        return false;
    }

    @Override
    public boolean isClientAuthenticated() {
        return false;
    }

    @Override
    public void reparentLightObjects(IDfId iDfId, IDfList iDfList) throws DfException {

    }

    @Override
    public void flushObject(IDfId iDfId) throws DfException {

    }

    @Override
    public void flushCachedQuery(String s) throws DfException {

    }

    @Override
    public void killSession(IDfId iDfId, String s, String s1) throws DfException {

    }

    @Override
    public IDfSessionScopeManager getSessionScopeManager() {
        return null;
    }

    @Override
    public IDfFtConfig getFtConfig() throws DfException {
        return null;
    }

    @Override
    public IDfMessageQueueManager getMessageQueueManager() {
        return null;
    }

    @Override
    public boolean requestDormancy() throws DfException {
        return false;
    }

    @Override
    public boolean requestDormancy(boolean b) throws DfException {
        return false;
    }

    @Override
    public DormantStatus checkDormantStatus() throws DfException {
        return null;
    }

    @Override
    public DormantStatus checkDormantStatus(boolean b) throws DfException {
        return null;
    }

    @Override
    public boolean makeActive() throws DfException {
        return false;
    }

    @Override
    public boolean makeActive(boolean b) throws DfException {
        return false;
    }

    @Override
    public boolean enableSaveInDormantState() throws DfException {
        return false;
    }

    @Override
    public boolean disableSaveInDormantState() throws DfException {
        return false;
    }

    @Override
    public boolean projectDormantStatus() throws DfException {
        return false;
    }

    @Override
    public boolean projectActiveStatus() throws DfException {
        return false;
    }

    @Override
    public IDfCollection startGatheringMetrics(List<String> list) throws DfException {
        return null;
    }

    @Override
    public IDfCollection stopGatheringMetrics(List<String> list) throws DfException {
        return null;
    }

    @Override
    public IDfCollection collectMetrics(List<String> list) throws DfException {
        return null;
    }

    @Override
    public IDfCollection collectMetrics(List<String> list, String s) throws DfException {
        return null;
    }

    @Override
    public IDfCollection listMetricsState() throws DfException {
        return null;
    }

    @Override
    public boolean resetMetrics() throws DfException {
        return false;
    }
}
