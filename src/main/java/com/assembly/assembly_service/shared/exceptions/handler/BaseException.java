package com.assembly.assembly_service.shared.exceptions.handler;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {
    protected BaseException(String message) {
        super(message);
    }
    public abstract HttpStatus httpStatus();
}
