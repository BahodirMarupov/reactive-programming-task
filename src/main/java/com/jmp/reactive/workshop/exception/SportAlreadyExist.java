package com.jmp.reactive.workshop.exception;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 06/07/2022
 */
public class SportAlreadyExist extends RuntimeException{
    public SportAlreadyExist(String message) {
        super(message);
    }
}
