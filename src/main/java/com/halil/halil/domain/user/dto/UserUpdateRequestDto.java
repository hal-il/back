package com.halil.halil.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserUpdateRequestDto {
    @NotBlank(message = "닉네임은 필수 입력값입니다.")
    private String nickname;
}
