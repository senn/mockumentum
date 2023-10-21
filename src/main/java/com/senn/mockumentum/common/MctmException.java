package com.senn.mockumentum.common;

import com.documentum.fc.common.DfException;

public class MctmException extends DfException {

    public MctmException() {
        super();
    }

    public MctmException(String message) {
        super(message);
    }

    public MctmException(Throwable throwable) {
        super(throwable);
    }

    public MctmException(String message, Throwable cause) {
        super(message, cause);
    }

}
