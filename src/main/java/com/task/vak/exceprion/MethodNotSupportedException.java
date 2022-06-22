package com.task.vak.exceprion;

public class MethodNotSupportedException extends IllegalCallerException{

    private static final long serialVersionUID = 6646L;
    private static final String METHOD_NOT_SUPPORTED = "Method not supported";

    public MethodNotSupportedException(String message) {
        super(message.isEmpty() ? METHOD_NOT_SUPPORTED : message);
    }

    public MethodNotSupportedException() {
        super(METHOD_NOT_SUPPORTED);
    }

}
