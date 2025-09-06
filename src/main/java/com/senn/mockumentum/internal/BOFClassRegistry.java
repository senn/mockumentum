package com.senn.mockumentum.internal;

import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.common.DfDocbaseConstants;
import com.senn.mockumentum.client.MctmSysObject;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BOFClassRegistry {

    public static final String BASE_SUPER_TYPE = "_base";

    private static final Map<String, String> superTypeMapping = new HashMap<>();
    private static final Map<String, Class<? extends IDfSysObject>> bofClassMapping = new HashMap<>();

    public static void registerObjectType(@NotNull String objectType, @NotNull String superType, Class<? extends IDfSysObject> bofClass) {
        if (bofClass == null) {
            bofClass = MctmSysObject.class;
        }
        String registeredSuperType = superTypeMapping.putIfAbsent(objectType, superType);
        if (registeredSuperType != null) {
            throw new MctmInitializationException(String.format("objectType '%s' already registered - superType=%s", objectType, registeredSuperType));
        }
        Class<?> registeredBOFClass = bofClassMapping.putIfAbsent(objectType, bofClass);
        if (registeredBOFClass != null) {
            throw new MctmInitializationException(String.format("objectType '%s' already registered - bofClass=%s", objectType, registeredBOFClass.getName()));
        }
    }

    public static String getSuperType(@NotNull String objectType) {
        return superTypeMapping.get(objectType);
    }

    public static Class<? extends IDfSysObject> getBOFClass(@Nullable String objectType) {
        if  (objectType == null) {
            return bofClassMapping.get(DfDocbaseConstants.DM_SYSOBJECT);
        }
        return bofClassMapping.get(objectType);
    }
}
