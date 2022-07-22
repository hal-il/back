package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.UserLoginResponseDto;

public interface UserService {
    UserLoginResponseDto findUserByCode(String code);
}