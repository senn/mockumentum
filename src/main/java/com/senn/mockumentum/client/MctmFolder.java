package com.senn.mockumentum.client;

import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.client.IDfFolder;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.common.DfException;
import com.senn.mockumentum.internal.ObjectIdRegistry;

/**
 * Mockumentum implementation of {@link IDfFolder}.
 * Not all functionality is exactly the same as in Documentum.
 *
 * @author Bart Thierens
 */
public class MctmFolder extends MctmSysObject implements IDfFolder {

    private final boolean isCabinet;

    public MctmFolder(IDfSession session) throws DfException {
        this(session, false);
    }

    public MctmFolder(IDfSession session, boolean isCabinet) throws DfException {
        super(session, isCabinet ? ObjectIdRegistry.ObjectType.CABINET : ObjectIdRegistry.ObjectType.FOLDER);
        this.isCabinet = isCabinet;
    }

    @Override
    public String getFolderPath(int i) throws DfException {
        return null;
    }

    @Override
    public int getFolderPathCount() throws DfException {
        return 0;
    }

    @Override
    public String getAncestorId(int i) throws DfException {
        return null;
    }

    @Override
    public int getAncestorIdCount() throws DfException {
        return 0;
    }

    @Override
    public IDfCollection getContents(String s) throws DfException {
        return null;
    }

    public boolean isCabinet() {
        return isCabinet;
    }
}
