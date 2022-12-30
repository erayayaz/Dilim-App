package com.example.Dilim.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "There is no news in these category")
public class NoContentException extends RuntimeException{
    public NoContentException(String message) {
        super(message);
    }
}
