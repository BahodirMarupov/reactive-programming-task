package com.jmp.reactive.workshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 06/07/2022
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SportAlreadyExist.class)
    public ResponseEntity<String> handleSportAlreadyExistException(SportAlreadyExist e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
