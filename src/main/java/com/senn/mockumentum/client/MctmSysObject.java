package com.senn.mockumentum.client;

import com.documentum.fc.client.IDfACL;
import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.client.IDfContentCollection;
import com.documentum.fc.client.IDfEnumeration;
import com.documentum.fc.client.IDfFormat;
import com.documentum.fc.client.IDfPermit;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.client.IDfVersionLabels;
import com.documentum.fc.client.IDfVersionPolicy;
import com.documentum.fc.client.IDfVirtualDocument;
import com.documentum.fc.client.acs.IDfAcsTransferPreferences;
import com.documentum.fc.client.acs.IDfContentTransferCapability;
import com.documentum.fc.client.content.IDfContentAvailability;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.IDfId;
import com.documentum.fc.common.IDfList;
import com.documentum.fc.common.IDfTime;
import com.senn.mockumentum.internal.ObjectIdRegistry;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Mockumentum implementation of {@link IDfSysObject}.
 * Not all functionality is exactly the same as in Documentum.
 *
 * @author Bart Thierens
 */
public class MctmSysObject extends MctmPersistentObject implements IDfSysObject {

    public MctmSysObject(IDfSession session) throws DfException {
        this(session, ObjectIdRegistry.ObjectType.SYSOBJECT);
    }

    public MctmSysObject(IDfSession session, ObjectIdRegistry.ObjectType objectType) throws DfException {
        super(session, objectType);
    }

    @Override
    public IDfId saveAsNew(boolean b) throws DfException {
        return null;
    }

    @Override
    public boolean areAttributesModifiable() throws DfException {
        return false;
    }

    @Override
    public boolean isImmutable() throws DfException {
        return false;
    }

    @Override
    public boolean isPublic() throws DfException {
        return false;
    }

    @Override
    public String getObjectName() throws DfException {
        return null;
    }

    @Override
    public void setObjectName(String s) throws DfException {

    }

    @Override
    public String getTypeName() throws DfException {
        return null;
    }

    @Override
    public String getTitle() throws DfException {
        return null;
    }

    @Override
    public void setTitle(String s) throws DfException {

    }

    @Override
    public String getSubject() throws DfException {
        return null;
    }

    @Override
    public void setSubject(String s) throws DfException {

    }

    @Override
    public int getAuthorsCount() throws DfException {
        return 0;
    }

    @Override
    public String getAuthors(int i) throws DfException {
        return null;
    }

    @Override
    public void setAuthors(int i, String s) throws DfException {

    }

    @Override
    public int getKeywordsCount() throws DfException {
        return 0;
    }

    @Override
    public String getKeywords(int i) throws DfException {
        return null;
    }

    @Override
    public void setKeywords(int i, String s) throws DfException {

    }

    @Override
    public String getApplicationType() throws DfException {
        return null;
    }

    @Override
    public void setApplicationType(String s) throws DfException {

    }

    @Override
    public String getSpecialApp() throws DfException {
        return null;
    }

    @Override
    public void setSpecialApp(String s) throws DfException {

    }

    @Override
    public boolean isHidden() throws DfException {
        return false;
    }

    @Override
    public void setHidden(boolean b) throws DfException {

    }

    @Override
    public String getStatus() throws DfException {
        return null;
    }

    @Override
    public void setStatus(String s) throws DfException {

    }

    @Override
    public IDfTime getCreationDate() throws DfException {
        return null;
    }

    @Override
    public IDfTime getAccessDate() throws DfException {
        return null;
    }

    @Override
    public IDfTime getModifyDate() throws DfException {
        return null;
    }

    @Override
    public String getModifier() throws DfException {
        return null;
    }

    @Override
    public IDfTime getRetentionDate() throws DfException {
        return null;
    }

    @Override
    public boolean isArchived() throws DfException {
        return false;
    }

    @Override
    public void setArchived(boolean b) throws DfException {

    }

    @Override
    public boolean getFullText() throws DfException {
        return false;
    }

    @Override
    public void setFullText(boolean b) throws DfException {

    }

    @Override
    public String getLogEntry() throws DfException {
        return null;
    }

    @Override
    public void setLogEntry(String s) throws DfException {

    }

    @Override
    public void saveLock() throws DfException {

    }

    @Override
    public String getLockOwner() throws DfException {
        return null;
    }

    @Override
    public IDfTime getLockDate() throws DfException {
        return null;
    }

    @Override
    public String getLockMachine() throws DfException {
        return null;
    }

    @Override
    public IDfId getAntecedentId() throws DfException {
        return null;
    }

    @Override
    public IDfId getChronicleId() throws DfException {
        return null;
    }

    @Override
    public IDfCollection getVersions(String s) throws DfException {
        return null;
    }

    @Override
    public IDfVersionPolicy getVersionPolicy() throws DfException {
        return null;
    }

    @Override
    public boolean getLatestFlag() throws DfException {
        return false;
    }

    @Override
    public String getImplicitVersionLabel() throws DfException {
        return null;
    }

    @Override
    public void mark(String s) throws DfException {

    }

    @Override
    public void unmark(String s) throws DfException {

    }

    @Override
    public IDfVersionLabels getVersionLabels() throws DfException {
        return null;
    }

    @Override
    public int getVersionLabelCount() throws DfException {
        return 0;
    }

    @Override
    public String getVersionLabel(int i) throws DfException {
        return null;
    }

    @Override
    public IDfId branch(String s) throws DfException {
        return null;
    }

    @Override
    public int getBranchCount() throws DfException {
        return 0;
    }

    @Override
    public String getDirectDescendant() throws DfException {
        return null;
    }

    @Override
    public void checkout() throws DfException {

    }

    @Override
    public IDfId checkoutEx(String s, String s1, String s2) throws DfException {
        return null;
    }

    @Override
    public void cancelCheckout() throws DfException {

    }

    @Override
    public void cancelCheckoutEx(boolean b, String s, String s1) throws DfException {

    }

    @Override
    public IDfId checkin(boolean b, String s) throws DfException {
        return null;
    }

    @Override
    public IDfId checkinEx(boolean b, String s, String s1, String s2, String s3, String s4) throws DfException {
        return null;
    }

    @Override
    public boolean isCheckedOut() throws DfException {
        return false;
    }

    @Override
    public boolean isCheckedOutBy(String s) throws DfException {
        return false;
    }

    @Override
    public void prune(boolean b) throws DfException {

    }

    @Override
    public void destroyAllVersions() throws DfException {

    }

    @Override
    public int getReferenceCount() throws DfException {
        return 0;
    }

    @Override
    public boolean getHasFolder() throws DfException {
        return false;
    }

    @Override
    public int getFolderIdCount() throws DfException {
        return 0;
    }

    @Override
    public IDfId getFolderId(int i) throws DfException {
        return null;
    }

    @Override
    public IDfId getCabinetId() throws DfException {
        return null;
    }

    @Override
    public void link(String s) throws DfException {

    }

    @Override
    public void unlink(String s) throws DfException {

    }

    @Override
    public IDfCollection getLocations(String s) throws DfException {
        return null;
    }

    @Override
    public String getCreatorName() throws DfException {
        return null;
    }

    @Override
    public String getOwnerName() throws DfException {
        return null;
    }

    @Override
    public void setOwnerName(String s) throws DfException {

    }

    @Override
    public int getOwnerPermit() throws DfException {
        return 0;
    }

    @Override
    public void setOwnerPermit(int i) throws DfException {

    }

    @Override
    public String getGroupName() throws DfException {
        return null;
    }

    @Override
    public void setGroupName(String s) throws DfException {

    }

    @Override
    public int getGroupPermit() throws DfException {
        return 0;
    }

    @Override
    public void setGroupPermit(int i) throws DfException {

    }

    @Override
    public int getWorldPermit() throws DfException {
        return 0;
    }

    @Override
    public void setWorldPermit(int i) throws DfException {

    }

    @Override
    public int getPermit() throws DfException {
        return 0;
    }

    @Override
    public int getPermitEx(String s) throws DfException {
        return 0;
    }

    @Override
    public int getAccessorCount() throws DfException {
        return 0;
    }

    @Override
    public String getAccessorName(int i) throws DfException {
        return null;
    }

    @Override
    public int getAccessorPermitType(int i) throws DfException {
        return 0;
    }

    @Override
    public String getAccessorPermit(int i) throws DfException {
        return null;
    }

    @Override
    public int getXPermit(String s) throws DfException {
        return 0;
    }

    @Override
    public int getAccessorXPermit(int i) throws DfException {
        return 0;
    }

    @Override
    public String getAccessorXPermitNames(int i) throws DfException {
        return null;
    }

    @Override
    public String getAccessorApplicationPermit(int i) throws DfException {
        return null;
    }

    @Override
    public boolean hasPermission(String s, String s1) throws DfException {
        return false;
    }

    @Override
    public String getXPermitNames(String s) throws DfException {
        return null;
    }

    @Override
    public String getXPermitList() throws DfException {
        return null;
    }

    @Override
    public void grant(String s, int i, String s1) throws DfException {

    }

    @Override
    public void grantPermit(IDfPermit iDfPermit) throws DfException {

    }

    @Override
    public void revoke(String s, String s1) throws DfException {

    }

    @Override
    public void revokePermit(IDfPermit iDfPermit) throws DfException {

    }

    @Override
    public IDfList getPermissions() throws DfException {
        return null;
    }

    @Override
    public IDfACL getACL() throws DfException {
        return null;
    }

    @Override
    public void setACL(IDfACL iDfACL) throws DfException {

    }

    @Override
    public void useACL(String s) throws DfException {

    }

    @Override
    public void revertACL() throws DfException {

    }

    @Override
    public String getACLName() throws DfException {
        return null;
    }

    @Override
    public void setACLName(String s) throws DfException {

    }

    @Override
    public String getACLDomain() throws DfException {
        return null;
    }

    @Override
    public void setACLDomain(String s) throws DfException {

    }

    @Override
    public boolean getAclRefValid() throws DfException {
        return false;
    }

    @Override
    public IDfId getContentsId() throws DfException {
        return null;
    }

    @Override
    public String getContentType() throws DfException {
        return null;
    }

    @Override
    public void setContentType(String s) throws DfException {

    }

    @Override
    public IDfFormat getFormat() throws DfException {
        return null;
    }

    @Override
    public int getPageCount() throws DfException {
        return 0;
    }

    @Override
    public long getContentSize() throws DfException {
        return 0;
    }

    @Override
    public String getStorageType() throws DfException {
        return null;
    }

    @Override
    public void setStorageType(String s) throws DfException {

    }

    @Override
    public int getContentStateCount() throws DfException {
        return 0;
    }

    @Override
    public int getContentState(int i) throws DfException {
        return 0;
    }

    @Override
    public IDfCollection getCollectionForContent(String s, int i) throws DfException {
        return null;
    }

    @Override
    public IDfCollection getCollectionForContentEx2(String s, int i, String s1) throws DfException {
        return null;
    }

    @Override
    public IDfCollection getCollectionForContentEx3(String s, int i, String s1, boolean b) throws DfException {
        return null;
    }

    @Override
    public IDfContentCollection getCollectionForContentEx4(String s, int i, String s1, boolean b) throws DfException {
        return null;
    }

    @Override
    public ByteArrayInputStream getContent() throws DfException {
        return null;
    }

    @Override
    public ByteArrayInputStream getContentEx(String s, int i) throws DfException {
        return null;
    }

    @Override
    public ByteArrayInputStream getContentEx2(String s, int i, String s1) throws DfException {
        return null;
    }

    @Override
    public ByteArrayInputStream getContentEx3(String s, int i, String s1, boolean b) throws DfException {
        return null;
    }

    @Override
    public String getFile(String s) throws DfException {
        return null;
    }

    @Override
    public String getFileEx(String s, String s1, int i, boolean b) throws DfException {
        return null;
    }

    @Override
    public String getFileEx2(String s, String s1, int i, String s2, boolean b) throws DfException {
        return null;
    }

    @Override
    public String getPath(int i) throws DfException {
        return null;
    }

    @Override
    public String getPathEx(int i, String s) throws DfException {
        return null;
    }

    @Override
    public String getPathEx2(String s, int i, String s1, boolean b) throws DfException {
        return null;
    }

    @Override
    public boolean setContent(ByteArrayOutputStream byteArrayOutputStream) throws DfException {
        return false;
    }

    @Override
    public boolean setContentEx(ByteArrayOutputStream byteArrayOutputStream, String s, int i) throws DfException {
        return false;
    }

    @Override
    public boolean setContentEx2(ByteArrayOutputStream byteArrayOutputStream, String s, int i, boolean b) throws DfException {
        return false;
    }

    @Override
    public void setStringContentAttribute(String s, String s1, String s2, int i, String s3) throws DfException {

    }

    @Override
    public void setTimeContentAttribute(String s, IDfTime iDfTime, String s1, int i, String s2) throws DfException {

    }

    @Override
    public void setDoubleContentAttribute(String s, double v, String s1, int i, String s2) throws DfException {

    }

    @Override
    public String getStringContentAttr(String s, String s1, int i, String s2) throws DfException {
        return null;
    }

    @Override
    public IDfTime getTimeContentAttr(String s, String s1, int i, String s2) throws DfException {
        return null;
    }

    @Override
    public Double getDoubleContentAttr(String s, String s1, int i, String s2) throws DfException {
        return null;
    }

    @Override
    public void setFile(String s) throws DfException {

    }

    @Override
    public void setFileEx(String s, String s1, int i, String s2) throws DfException {

    }

    @Override
    public void setPath(String s, String s1, int i, String s2) throws DfException {

    }

    @Override
    public void appendContent(ByteArrayOutputStream byteArrayOutputStream) throws DfException {

    }

    @Override
    public void appendContentEx(ByteArrayOutputStream byteArrayOutputStream, boolean b) throws DfException {

    }

    @Override
    public void appendFile(String s) throws DfException {

    }

    @Override
    public void appendFileEx(String s, String s1) throws DfException {

    }

    @Override
    public void insertContent(ByteArrayOutputStream byteArrayOutputStream, int i) throws DfException {

    }

    @Override
    public void insertContentEx(ByteArrayOutputStream byteArrayOutputStream, int i, boolean b) throws DfException {

    }

    @Override
    public void insertFile(String s, int i) throws DfException {

    }

    @Override
    public void insertFileEx(String s, int i, String s1) throws DfException {

    }

    @Override
    public void addRendition(String s, String s1) throws DfException {

    }

    @Override
    public void addRenditionEx(String s, String s1, int i, String s2, boolean b) throws DfException {

    }

    @Override
    public void addRenditionEx2(String s, String s1, int i, String s2, String s3, boolean b, boolean b1, boolean b2) throws DfException {

    }

    @Override
    public void addRenditionEx3(String s, String s1, int i, String s2, String s3, boolean b, boolean b1, boolean b2, String s4) throws DfException {

    }

    @Override
    public IDfCollection getRenditions(String s) throws DfException {
        return null;
    }

    @Override
    public void removeContent(int i) throws DfException {

    }

    @Override
    public void removeRendition(String s) throws DfException {

    }

    @Override
    public void removeRenditionEx(String s, int i, boolean b) throws DfException {

    }

    @Override
    public void removeRenditionEx2(String s, int i, String s1, boolean b) throws DfException {

    }

    @Override
    public void bindFile(int i, IDfId iDfId, int i1) throws DfException {

    }

    @Override
    public void mount(String s) throws DfException {

    }

    @Override
    public void addNote(IDfId iDfId, boolean b) throws DfException {

    }

    @Override
    public void removeNote(IDfId iDfId) throws DfException {

    }

    @Override
    public IDfId getPolicyId() throws DfException {
        return null;
    }

    @Override
    public String getPolicyName() throws DfException {
        return null;
    }

    @Override
    public int getResumeState() throws DfException {
        return 0;
    }

    @Override
    public String getResumeStateName() throws DfException {
        return null;
    }

    @Override
    public int getCurrentState() throws DfException {
        return 0;
    }

    @Override
    public String getCurrentStateName() throws DfException {
        return null;
    }

    @Override
    public void attachPolicy(IDfId iDfId, String s, String s1) throws DfException {

    }

    @Override
    public void detachPolicy() throws DfException {

    }

    @Override
    public void promote(String s, boolean b, boolean b1) throws DfException {

    }

    @Override
    public String getPreviousStateName() throws DfException {
        return null;
    }

    @Override
    public String getNextStateName() throws DfException {
        return null;
    }

    @Override
    public boolean canPromote() throws DfException {
        return false;
    }

    @Override
    public void schedulePromote(String s, IDfTime iDfTime, boolean b) throws DfException {

    }

    @Override
    public void cancelScheduledPromote(IDfTime iDfTime) throws DfException {

    }

    @Override
    public boolean canDemote() throws DfException {
        return false;
    }

    @Override
    public void demote(String s, boolean b) throws DfException {

    }

    @Override
    public void scheduleDemote(String s, IDfTime iDfTime) throws DfException {

    }

    @Override
    public void cancelScheduledDemote(IDfTime iDfTime) throws DfException {

    }

    @Override
    public void suspend(String s, boolean b, boolean b1) throws DfException {

    }

    @Override
    public boolean canSuspend() throws DfException {
        return false;
    }

    @Override
    public boolean isSuspended() throws DfException {
        return false;
    }

    @Override
    public void scheduleSuspend(String s, IDfTime iDfTime, boolean b) throws DfException {

    }

    @Override
    public void cancelScheduledSuspend(IDfTime iDfTime) throws DfException {

    }

    @Override
    public void resume(String s, boolean b, boolean b1, boolean b2) throws DfException {

    }

    @Override
    public boolean canResume() throws DfException {
        return false;
    }

    @Override
    public void scheduleResume(String s, IDfTime iDfTime, boolean b, boolean b1) throws DfException {

    }

    @Override
    public void cancelScheduledResume(IDfTime iDfTime) throws DfException {

    }

    @Override
    public boolean isVirtualDocument() throws DfException {
        return false;
    }

    @Override
    public void setIsVirtualDocument(boolean b) throws DfException {

    }

    @Override
    public IDfId getAssembledFromId() throws DfException {
        return null;
    }

    @Override
    public int getFrozenAssemblyCount() throws DfException {
        return 0;
    }

    @Override
    public boolean getHasFrozenAssembly() throws DfException {
        return false;
    }

    @Override
    public String getCompoundArchitecture() throws DfException {
        return null;
    }

    @Override
    public void setCompoundArchitecture(String s) throws DfException {

    }

    @Override
    public String getResolutionLabel() throws DfException {
        return null;
    }

    @Override
    public void setResolutionLabel(String s) throws DfException {

    }

    @Override
    public int getLinkCount() throws DfException {
        return 0;
    }

    @Override
    public int getLinkHighCount() throws DfException {
        return 0;
    }

    @Override
    public boolean isLinkResolved() throws DfException {
        return false;
    }

    @Override
    public void setLinkResolved(boolean b) throws DfException {

    }

    @Override
    public IDfId appendPart(IDfId iDfId, String s, boolean b, boolean b1, int i) throws DfException {
        return null;
    }

    @Override
    public IDfId insertPart(IDfId iDfId, String s, IDfId iDfId1, double v, boolean b, boolean b1, boolean b2, int i) throws DfException {
        return null;
    }

    @Override
    public void removePart(IDfId iDfId, double v, boolean b) throws DfException {

    }

    @Override
    public void updatePart(IDfId iDfId, String s, double v, boolean b, boolean b1, int i) throws DfException {

    }

    @Override
    public void updatePartEx(IDfId iDfId, String s, double v, boolean b, boolean b1, int i, String s1, String s2) throws DfException {

    }

    @Override
    public IDfCollection assemble(IDfId iDfId, int i, String s, String s1) throws DfException {
        return null;
    }

    @Override
    public void disassemble() throws DfException {

    }

    @Override
    public boolean isFrozen() throws DfException {
        return false;
    }

    @Override
    public void freeze(boolean b) throws DfException {

    }

    @Override
    public void unfreeze(boolean b) throws DfException {

    }

    @Override
    public IDfVirtualDocument asVirtualDocument(String s, boolean b) throws DfException {
        return null;
    }

    @Override
    public int getComponentIdCount() throws DfException {
        return 0;
    }

    @Override
    public IDfId getComponentId(int i) throws DfException {
        return null;
    }

    @Override
    public int getContainIdCount() throws DfException {
        return 0;
    }

    @Override
    public IDfId getContainId(int i) throws DfException {
        return null;
    }

    @Override
    public boolean isReference() throws DfException {
        return false;
    }

    @Override
    public String getMasterDocbase() throws DfException {
        return null;
    }

    @Override
    public IDfId addReference(IDfId iDfId, String s, String s1) throws DfException {
        return null;
    }

    @Override
    public void refreshReference() throws DfException {

    }

    @Override
    public IDfId getRemoteId() throws DfException {
        return null;
    }

    @Override
    public IDfId getAliasSetId() throws DfException {
        return null;
    }

    @Override
    public String getAliasSet() throws DfException {
        return null;
    }

    @Override
    public String resolveAlias(String s) throws DfException {
        return null;
    }

    @Override
    public String print(String s, boolean b, boolean b1, int i, int i1, int i2) throws DfException {
        return null;
    }

    @Override
    public IDfId queue(String s, String s1, int i, boolean b, IDfTime iDfTime, String s2) throws DfException {
        return null;
    }

    @Override
    public boolean getHasEvents() throws DfException {
        return false;
    }

    @Override
    public IDfCollection getRouters(String s, String s1) throws DfException {
        return null;
    }

    @Override
    public IDfCollection getWorkflows(String s, String s1) throws DfException {
        return null;
    }

    @Override
    public IDfCollection getVdmPath(IDfId iDfId, boolean b, String s) throws DfException {
        return null;
    }

    @Override
    public IDfCollection getVdmPathDQL(IDfId iDfId, boolean b, String s, String s1, String s2) throws DfException {
        return null;
    }

    @Override
    public String getExceptionStateName() throws DfException {
        return null;
    }

    @Override
    public IDfId addDigitalSignature(String s, String s1) throws DfException {
        return null;
    }

    @Override
    public IDfId addESignature(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9) throws DfException {
        return null;
    }

    @Override
    public void verifyESignature() throws DfException {

    }

    @Override
    public IDfContentAvailability getContentAvailability(String s, int i, String s1, String s2) throws DfException {
        return null;
    }

    @Override
    public boolean isContentTransferCapabilityEnabled(String s, IDfContentTransferCapability iDfContentTransferCapability) throws DfException {
        return false;
    }

    @Override
    public IDfEnumeration getAcsRequests(String s, int i, String s1, IDfAcsTransferPreferences iDfAcsTransferPreferences) throws DfException {
        return null;
    }

    @Override
    public IDfTime getRetainUntilDate() throws DfException {
        return null;
    }

    @Override
    public int getRetainerCount() throws DfException {
        return 0;
    }

    @Override
    public IDfId getRetainerId(int i) throws DfException {
        return null;
    }

    @Override
    public long getContentSize(int i, String s, String s1) throws DfException {
        return 0;
    }

    @Override
    public long getOtherFileSize(int i, String s, String s1) throws DfException {
        return 0;
    }
}
