package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.UserLoginResponseDto;
import com.halil.halil.domain.user.dto.UserResponseDto;
import com.halil.halil.domain.user.dto.UserUpdateRequestDto;
import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.dto.UserCreateResponseDto;
import com.halil.halil.domain.user.entity.User;

import java.util.Optional;

public interface UserService {
    UserLoginResponseDto findUserByCode(String code);
    UserResponseDto updateUserInfo(String email, UserUpdateRequestDto userUpdateRequestDto);
    void updateRefreshToken(String email, String refreshToken);
    UserCreateResponseDto createUser(UserCreateRequestDto userCreateRequestDto);
}