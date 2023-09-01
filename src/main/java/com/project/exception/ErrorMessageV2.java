package com.project.exception;

import java.util.Date;

public class ErrorMessageV2 implements ErrorMessage {
    private final int statusCode;
    private final Date timestamp;
    private final String message;
    private final String description;

    public ErrorMessageV2(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
