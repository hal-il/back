package com.halil.halil.domain.user.dto;

import com.halil.halil.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserUpdateRequestDto {
    private String email;
    private String nickname;

}
