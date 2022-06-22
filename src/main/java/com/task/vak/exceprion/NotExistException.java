package com.task.vak.exceprion;

public class NotExistException extends IllegalStateException {

    private static final String MESSAGE = "Not exists";

    public NotExistException(String message) {
        super(message.isEmpty() ? MESSAGE : message);
    }

    public NotExistException() {
        super(MESSAGE);
    }
}
