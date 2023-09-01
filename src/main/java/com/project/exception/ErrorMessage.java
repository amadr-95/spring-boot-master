package com.project.exception;

import java.util.Date;

public interface ErrorMessage {

    String getMessage();

    int getStatusCode();

    Date getTimestamp();

}
