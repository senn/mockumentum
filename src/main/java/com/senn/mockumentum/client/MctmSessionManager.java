package com.senn.mockumentum.client;

import com.documentum.fc.client.DfAuthenticationException;
import com.documentum.fc.client.DfIdentityException;
import com.documentum.fc.client.DfPrincipalException;
import com.documentum.fc.client.DfServiceException;
import com.documentum.fc.client.IDfScopeManager;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.client.IDfSessionManager;
import com.documentum.fc.client.IDfSessionManagerConfig;
import com.documentum.fc.client.IDfSessionManagerEventListener;
import com.documentum.fc.client.IDfSessionManagerStatistics;
import com.documentum.fc.common.IDfLoginInfo;

/**
 * Mockumentum implementation of {@link IDfSessionManager}.
 * Not all functionality available in Documentum is provided.
 *
 * @author Bart Thierens
 */
public class MctmSessionManager implements IDfSessionManager {

    @Override
    public void setPrincipalName(String s) {

    }

    @Override
    public String getPrincipalName() {
        return null;
    }

    @Override
    public void setLocale(String s) {

    }

    @Override
    public String getLocale() {
        return null;
    }

    @Override
    public void setIdentity(String s, IDfLoginInfo iDfLoginInfo) throws DfServiceException {

    }

    @Override
    public IDfLoginInfo getIdentity(String s) {
        return null;
    }

    @Override
    public boolean hasIdentity(String s) {
        return false;
    }

    @Override
    public void clearIdentity(String s) {

    }

    @Override
    public void clearIdentities() {

    }

    @Override
    public void flushSessions() {

    }

    @Override
    public void authenticate(String s) throws DfIdentityException, DfAuthenticationException, DfPrincipalException, DfServiceException {

    }

    @Override
    public IDfSession getSession(String s) throws DfIdentityException, DfAuthenticationException, DfPrincipalException, DfServiceException {
        return null;
    }

    @Override
    public IDfSession newSession(String s) throws DfIdentityException, DfAuthenticationException, DfPrincipalException, DfServiceException {
        return null;
    }

    @Override
    public void release(IDfSession iDfSession) {

    }

    @Override
    public void beginTransaction() throws DfServiceException {

    }

    @Override
    public void commitTransaction() throws DfServiceException {

    }

    @Override
    public void abortTransaction() throws DfServiceException {

    }

    @Override
    public boolean isTransactionActive() {
        return false;
    }

    @Override
    public void setTransactionRollbackOnly() {

    }

    @Override
    public boolean getTransactionRollbackOnly() {
        return false;
    }

    @Override
    public void beginClientControl() {

    }

    @Override
    public void endClientControl() throws DfServiceException {

    }

    @Override
    public IDfSessionManagerStatistics getStatistics() {
        return null;
    }

    @Override
    public IDfSessionManagerConfig getConfig() {
        return null;
    }

    @Override
    public IDfSessionManagerEventListener setListener(IDfSessionManagerEventListener iDfSessionManagerEventListener) {
        return null;
    }

    @Override
    public IDfScopeManager getScopeManager() {
        return null;
    }
}
