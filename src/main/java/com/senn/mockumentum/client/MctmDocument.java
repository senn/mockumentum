package com.senn.mockumentum.client;

import com.documentum.fc.client.IDfDocument;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.common.DfException;
import com.senn.mockumentum.internal.ObjectIdRegistry;

/**
 * Mockumentum implementation of {@link IDfDocument}.
 * Not all functionality is exactly the same as in Documentum.
 *
 * @author Bart Thierens
 */
public class MctmDocument extends MctmSysObject implements IDfDocument {

    public MctmDocument(IDfSession session) throws DfException {
        super(session, ObjectIdRegistry.ObjectType.DOCUMENT);
    }
}
