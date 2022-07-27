package com.halil.halil.domain.user.dto;

import lombok.*;

@Getter
public class UserCreateRequestDto {
    String email;
    String nickName;
    public UserCreateRequestDto(String email, String nickName){
        this.email=email;
        this.nickName=nickName;
    }
}
