package com.halil.halil.global.util.jwt;

public class InvalidAccessTokenException extends RuntimeException{
    public InvalidAccessTokenException() {
        super("사용 불가능한 access token 입니다.");
    }
}
