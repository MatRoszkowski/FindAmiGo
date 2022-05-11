package com.mateuszroszkowski.FindAmiGo.exception;

public class PasswordNotSufficientException extends RuntimeException{
    public PasswordNotSufficientException(String message) {
        super(message);
    }
}
