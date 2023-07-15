package com.amirhossein.salesinvoice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Amin nemati
 * @version 0.0.1
 * @since 1/21/21
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerException extends RuntimeException {

    public ServerException(String message) {
        super(message);
    }
}
