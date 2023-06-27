package com.esource.assignment.exception;

public class NoPrimesFoundException extends RuntimeException {
    public NoPrimesFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public NoPrimesFoundException(String errorMessage) {
        super(errorMessage);
    }

}
