package ru.hogwarts.school.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataNotFoundedException extends RuntimeException{
    public DataNotFoundedException() {
    }

    public DataNotFoundedException(String message) {
        super(message);
    }

    public DataNotFoundedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFoundedException(Throwable cause) {
        super(cause);
    }

    public DataNotFoundedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
