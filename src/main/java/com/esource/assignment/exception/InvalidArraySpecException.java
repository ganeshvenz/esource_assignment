package com.esource.assignment.exception;

public class InvalidArraySpecException extends RuntimeException {
    public InvalidArraySpecException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public InvalidArraySpecException(String errorMessage) {
        super(errorMessage);
    }

}
