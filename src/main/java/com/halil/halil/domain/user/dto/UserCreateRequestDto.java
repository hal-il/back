package com.halil.halil.domain.user.dto;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class UserCreateRequestDto {
    String email;
    String nickName;
    @Builder
    public UserCreateRequestDto(String email, String nickName){
        this.email=email;
        this.nickName=nickName;
    }
}
