package com.senn.mockumentum.test;

import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.common.DfException;

public class ExampleService {

    public String calculateUidForObject(IDfSysObject object) {
        if (object == null) {
            return getDefaultUid();
        }
        try {
            return object.getObjectId() + "_" + object.getOwnerName();
        } catch (DfException e) {
            return getDefaultUid();
        }
    }

    private String getDefaultUid() {
        return Long.toString(System.currentTimeMillis());
    }

}
