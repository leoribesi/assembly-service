package com.assembly.assembly_service.shared.exceptions;

import com.assembly.assembly_service.shared.exceptions.handler.BaseException;
import org.springframework.http.HttpStatus;

public class AlreadyExistsVoteException extends BaseException {

    public AlreadyExistsVoteException(String message) {
        super(message);
    }

    @Override
    public HttpStatus httpStatus() {
        return HttpStatus.CONFLICT;
    }
}
