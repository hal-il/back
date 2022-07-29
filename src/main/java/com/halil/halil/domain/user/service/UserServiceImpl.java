package com.halil.halil.domain.user.service;

import com.halil.halil.domain.login.service.LoginService;
import com.halil.halil.domain.user.dto.UserLoginResponseDto;
import com.halil.halil.domain.user.entity.User;
import com.halil.halil.domain.user.exception.NotExistUserException;
import com.halil.halil.domain.user.repository.UserRepository;
import com.halil.halil.global.util.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    private final JwtProvider jwtProvider;

    private final LoginService loginService;

    @Override
    public UserLoginResponseDto findUserByCode(String code) {
        String email = loginService.getEmailByCode(code);
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> {
            throw new NotExistUserException();
        });

        return new UserLoginResponseDto(jwtProvider.getToken(user.getNickName(), user.getEmail()));
    }
}
