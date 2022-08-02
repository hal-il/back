package com.halil.halil.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.halil.halil.domain.user.entity.User;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDto {

    private String email;
    private String nickName;

    public UserResponseDto(User user){
        this.email = user.getEmail();
        this.nickName = user.getNickName();
    }
}
