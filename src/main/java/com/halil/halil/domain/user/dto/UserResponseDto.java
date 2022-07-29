package com.halil.halil.domain.user.dto;

import com.halil.halil.domain.user.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private String email;
    private String nickname;

    public UserResponseDto(User user){
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }
}
