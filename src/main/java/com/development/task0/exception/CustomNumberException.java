package com.development.task0.exception;

public class CustomNumberException extends Exception {
    public CustomNumberException() {
    }

    public CustomNumberException(String message) {
        super(message);
    }

    public CustomNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomNumberException(Throwable cause) {
        super(cause);
    }

}
