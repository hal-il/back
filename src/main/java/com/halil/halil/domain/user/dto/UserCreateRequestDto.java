package com.halil.halil.domain.user.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequestDto {
    @NotNull
    @Email
    String email;
    @NotNull
    String nickName;
}
