package com.melt.shop.exception;

public class InternalServerErroeException extends RuntimeException {
    private static final long serialVersionUID = 45634456435456L;

    public InternalServerErroeException(String message) {
        super(message);
    }

    public InternalServerErroeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerErroeException(Throwable cause) {
        super(cause);
    }
}
