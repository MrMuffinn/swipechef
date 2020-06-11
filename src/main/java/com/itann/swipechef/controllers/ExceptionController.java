package com.itann.swipechef.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(value = WachtwoordOnjuistException.class)
    public ResponseEntity<Object> exception(WachtwoordOnjuistException exception) {
        return new ResponseEntity<>("Wachtwoord onjuist", HttpStatus.FORBIDDEN);
    }
}
