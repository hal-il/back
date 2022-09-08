package com.halil.halil.domain.user.exception;

public class ExistNicknameException extends RuntimeException{
    public ExistNicknameException(){
        super("중복 닉네임 입니다");
    }
}
