package com.nevermind.bu.exception;

public class GenericEngineException extends Exception {
    private String message;

    public GenericEngineException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public GenericEngineException(String message) {
        super(message);
    }

    public GenericEngineException(Throwable cause) {
        super(cause);
    }
}
