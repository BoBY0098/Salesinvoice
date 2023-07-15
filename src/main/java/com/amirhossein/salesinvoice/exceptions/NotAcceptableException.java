package com.amirhossein.salesinvoice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Mohammad Mahdi Kahool
 * @version 0.0.1
 * @since 1/21/21
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptableException extends RuntimeException {

    public NotAcceptableException(String message) {
        super(message);
    }
}