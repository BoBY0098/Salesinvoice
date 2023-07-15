package com.amirhossein.salesinvoice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnAuthException extends RuntimeException {

    public UnAuthException(String message) {
        super(message);
    }
}
