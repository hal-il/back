package com.halil.halil.domain.user.dto;

import com.halil.halil.domain.user.entity.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserCreateRequestDto {
    @NotBlank(message = "이메일은 비어있을 수 없습니다.")
    @Email
    private String email;
    @NotBlank(message = "닉네임은 비어있을 수 없습니다.")
    private String nickname;

    public User toEntity(){
        return User.builder().email(this.email).nickname(this.nickname).build();
    }
}
