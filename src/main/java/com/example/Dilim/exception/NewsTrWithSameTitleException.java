package com.example.Dilim.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "There is a news already has a same title.")
public class NewsTrWithSameTitleException extends RuntimeException{
    public NewsTrWithSameTitleException(String message) {
        super(message);
    }
}
