package com.thenxt.app.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String str) {
        super(str);
    }
}
