package com.project.exception;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorMessageV1 implements ErrorMessage {
    private final int statusCode;
    private final Date timestamp;
    private final String message;
    private final Throwable throwable;
}
