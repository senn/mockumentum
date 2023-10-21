package com.senn.mockumentum.internal;

import com.documentum.fc.client.IDfSysObject;
import com.senn.mockumentum.client.MctmSysObject;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

public class BOFClassRegistry {

    private static final Map<String, String> superTypeMapping = new HashMap<>();
    private static final Map<String, Class<? extends IDfSysObject>> bofClassMapping = new HashMap<>();

    public static void registerObjectType(@Nonnull String objectType, @Nonnull String superType, Class<? extends IDfSysObject> bofClass) {
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

    public static String getSuperType(@Nonnull String objectType) {
        return superTypeMapping.get(objectType);
    }

    public static Class<? extends IDfSysObject> getBOFClass(@Nonnull String objectType) {
        return bofClassMapping.get(objectType);
    }
}
