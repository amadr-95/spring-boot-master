package com.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    private ErrorMessage errorMessage;


    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorMessage> ApiRequestExceptionHandler(BadRequestException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        errorMessage = new ErrorMessageV1(
                status.value(),
                new Date(),
                e.getMessage(),
                e
        );
        return new ResponseEntity<>(errorMessage, status);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        errorMessage = new ErrorMessageV2(
                status.value(),
                new Date(),
                e.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, status);
    }
}
