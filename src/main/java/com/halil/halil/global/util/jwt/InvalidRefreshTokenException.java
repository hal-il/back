package com.halil.halil.global.util.jwt;

public class InvalidRefreshTokenException extends RuntimeException{
    public InvalidRefreshTokenException() {
        super("사용할 수 없는 refresh Token 입니다.");
    }
}
