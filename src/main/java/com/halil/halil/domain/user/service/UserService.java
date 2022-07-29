package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.UserResponseDto;
import com.halil.halil.domain.user.dto.UserUpdateRequestDto;
import com.halil.halil.domain.user.entity.User;

import java.util.Optional;

public interface UserService {
    UserResponseDto updateUserInfo(UserUpdateRequestDto userUpdateRequestDto);

}
