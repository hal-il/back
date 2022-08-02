package com.halil.halil.domain.user.dto;

import com.halil.halil.domain.user.entity.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequestDto {
    @NotBlank
    @Email
    String email;
    @NotBlank
    String nickName;

    public User toEntity(){
        return User.builder()
                .email(email)
                .nickname(nickName)
                .build();
    }
}
