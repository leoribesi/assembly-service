package com.assembly.assembly_service.shared.exceptions;

import com.assembly.assembly_service.shared.exceptions.handler.BaseException;
import org.springframework.http.HttpStatus;

public class SessionClosedException extends BaseException {

    public SessionClosedException(String message) {
        super(message);
    }

    @Override
    public HttpStatus httpStatus() {
        return HttpStatus.NOT_ACCEPTABLE;
    }
}
