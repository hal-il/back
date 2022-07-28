package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.UserUpdateRequestDto;
import com.halil.halil.domain.user.entity.User;

import java.util.Optional;

public interface UserService {
    User updateUserInfo(UserUpdateRequestDto userUpdateRequestDto);
    User findByEmail(String email);

}
