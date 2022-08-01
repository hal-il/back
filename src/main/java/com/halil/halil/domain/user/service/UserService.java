package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.dto.UserCreateResponseDto;


public interface UserService {
    UserCreateResponseDto CreateUser(UserCreateRequestDto userCreateRequestDto);
}