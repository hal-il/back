package com.halil.halil.domain.user.exception;

public class NotExistUserException extends RuntimeException{
    public NotExistUserException(){
        super("존재하지 않는 사용자입니다.");
    }
}
