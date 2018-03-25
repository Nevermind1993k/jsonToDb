package com.nevermind.bu.exception;

/**
 * Created by Oleksandr Ryzhkov on 04.11.2017.
 */
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
