package com.halil.halil.domain.user.exception;

public class ExistUserException extends RuntimeException{
    public ExistUserException(String message){
        super(message);
    }
}