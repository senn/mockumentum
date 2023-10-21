package com.senn.mockumentum.internal;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectIdRegistry {

    public enum ObjectType {
        CABINET("0c"),
        DOCUMENT("09"),
        FOLDER("0b"),
        SYSOBJECT("08");

        private final String typeId;

        ObjectType(String typeId) {
            this.typeId = typeId;
        }

        private String getTypeId() {
            return typeId;
        }
    }

    private static final Lock objectIdGenerationLock = new ReentrantLock(true);
    private static long counter = 0;

    public static String generateObjectId(ObjectType type) {
        try {
            objectIdGenerationLock.lock();
            return String.format(type.getTypeId() + "%014d", ++counter);
        }
        finally {
            objectIdGenerationLock.unlock();
        }
    }

}
