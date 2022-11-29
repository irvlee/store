package com.my.store.service.ex;

public class PasswordNoMatchException extends ServiceException {
    public PasswordNoMatchException() {
        super();
    }

    public PasswordNoMatchException(String message) {
        super(message);
    }

    public PasswordNoMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNoMatchException(Throwable cause) {
        super(cause);
    }

    protected PasswordNoMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
