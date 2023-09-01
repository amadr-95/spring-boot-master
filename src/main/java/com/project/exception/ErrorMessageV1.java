package com.project.exception;

import java.util.Date;


public class ErrorMessageV1 implements ErrorMessage {
    private final int statusCode;
    private final Date timestamp;
    private final String message;
    private final Throwable throwable;

    public ErrorMessageV1(int statusCode, Date timestamp, String message, Throwable throwable) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.throwable = throwable;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public Date getTimestamp() {
        return timestamp;
    }
}
