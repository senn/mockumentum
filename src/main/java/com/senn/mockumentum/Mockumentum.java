package com.senn.mockumentum;

import com.documentum.fc.client.IDfSession;
import com.documentum.fc.client.IDfSysObject;
import com.senn.mockumentum.client.MctmFolder;
import com.senn.mockumentum.client.MctmSession;
import com.senn.mockumentum.client.MctmSysObject;
import com.senn.mockumentum.internal.BOFClassRegistry;
import org.jetbrains.annotations.NotNull;

/**
 * Main entrypoint for Mockumentum context
 */
public final class Mockumentum {

    static {
        registerObjectType("dm_sysobject", "_base", MctmSysObject.class);
        registerObjectType("dm_folder", "dm_sysobject", MctmFolder.class);
        registerObjectType("dm_cabinet", "dm_folder", MctmFolder.class);
        registerObjectType("dm_document", "dm_sysobject", MctmSysObject.class);
    }

    @NotNull
    public static IDfSession session(@NotNull String userName) {
        return MctmSession.create(userName);
    }

    public static void registerObjectType(@NotNull String objectType, @NotNull String superType, Class<? extends IDfSysObject> bofClass) {
        BOFClassRegistry.registerObjectType(objectType, superType, bofClass);
    }

    public static void registerObjectType(@NotNull String objectType, @NotNull String superType) {
        Class<? extends IDfSysObject> parentBofClass = BOFClassRegistry.getBOFClass(superType);
        registerObjectType(objectType, superType, parentBofClass);
    }

}
