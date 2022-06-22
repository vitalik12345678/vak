package com.task.vak.exceprion;


public class ExistException extends IllegalStateException{

    private static final long serialVersionUID = 55525L;
    private static final String EXISTS_EXCEPTION = "Object exists";

    public ExistException(String message) {
        super((message == null || message.isEmpty()) ? EXISTS_EXCEPTION : message);
    }

    public ExistException() {
        super(EXISTS_EXCEPTION);
    }

}