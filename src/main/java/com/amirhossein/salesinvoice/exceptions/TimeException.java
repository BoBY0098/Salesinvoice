package com.amirhossein.salesinvoice.exceptions;


/**
 *
 * @author adrian
 */
public class TimeException extends Exception {

    public TimeException() {
        super("Cannot create time with this params");
    }

    public TimeException(String message) {
        super(message);
    }

}
