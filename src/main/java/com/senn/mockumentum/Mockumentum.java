package com.senn.mockumentum;

import com.documentum.fc.client.IDfPersistentObject;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.common.IDfValue;
import com.senn.mockumentum.client.MctmFolder;
import com.senn.mockumentum.client.MctmSession;
import com.senn.mockumentum.client.MctmSysObject;
import com.senn.mockumentum.internal.BOFClassRegistry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

import static com.documentum.fc.common.DfDocbaseConstants.DM_CABINET;
import static com.documentum.fc.common.DfDocbaseConstants.DM_DOCUMENT;
import static com.documentum.fc.common.DfDocbaseConstants.DM_FOLDER;
import static com.documentum.fc.common.DfDocbaseConstants.DM_SYSOBJECT;
import static com.documentum.fc.common.DfDocbaseConstants.R_OBJECT_TYPE;
import static com.senn.mockumentum.internal.BOFClassRegistry.BASE_SUPER_TYPE;

/**
 * Main entrypoint for Mockumentum context
 */
public final class Mockumentum {

    private final Map<String, ? extends IDfTypedObject> objectCache = new ConcurrentHashMap<>();

    private Mockumentum() {
        // default setup
        registerObjectType(DM_SYSOBJECT, BASE_SUPER_TYPE, MctmSysObject.class);
        registerObjectType(DM_SYSOBJECT, DM_SYSOBJECT, MctmFolder.class);
        registerObjectType(DM_CABINET, DM_FOLDER, MctmFolder.class);
        registerObjectType(DM_DOCUMENT, DM_SYSOBJECT, MctmSysObject.class);
    }

    @NotNull
    public static Mockumentum init() {
        return new Mockumentum();
    }

    @NotNull
    public IDfSession session(@NotNull String userName) {
        return MctmSession.create(userName);
    }

    @NotNull
    public <T extends IDfPersistentObject> T load(String jsonContent) {
        String objectType = values.get(R_OBJECT_TYPE).asString();
        Class<? extends IDfSysObject> bofClass = BOFClassRegistry.getBOFClass(objectType);
        bofClass.getDeclaredConstructor()
    }

    public void registerObjectType(@NotNull String objectType, @NotNull String superType, Class<? extends IDfSysObject> bofClass) {
        BOFClassRegistry.registerObjectType(objectType, superType, bofClass);
    }

    public void registerObjectType(@NotNull String objectType, @NotNull String superType) {
        Class<? extends IDfSysObject> parentBofClass = BOFClassRegistry.getBOFClass(superType);
        registerObjectType(objectType, superType, parentBofClass);
    }

}
