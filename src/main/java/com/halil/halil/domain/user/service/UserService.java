package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.dto.UserCreateResponseDto;
import com.halil.halil.domain.user.entity.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserService {
    UserCreateResponseDto CreateUser(UserCreateRequestDto userCreateRequestDto);
}