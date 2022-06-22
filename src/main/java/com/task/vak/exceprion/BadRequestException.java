package com.task.vak.exceprion;


public class BadRequestException extends IllegalArgumentException{

    private static final long serialVersionUID = 88842L;
    private static final String BAD_REQUEST_EXCEPTION = "Bad request";

    public BadRequestException(String message) {
        super((message == null || message.isEmpty()) ? BAD_REQUEST_EXCEPTION : message);
    }

    public BadRequestException() {
        super(BAD_REQUEST_EXCEPTION);
    }

}