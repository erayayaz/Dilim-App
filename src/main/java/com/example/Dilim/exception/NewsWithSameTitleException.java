package com.example.Dilim.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NewsWithSameTitleException extends RuntimeException {
    public NewsWithSameTitleException(String message) {
        super(message);
    }
}
