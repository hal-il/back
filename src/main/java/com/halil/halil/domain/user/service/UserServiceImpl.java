package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.*;
import com.halil.halil.domain.user.exception.ExistNicknameException;
import com.halil.halil.domain.user.exception.NotExistUserException;
import com.halil.halil.global.util.jwt.JwtProvider;
import com.halil.halil.domain.login.service.LoginService;
import com.halil.halil.domain.user.entity.User;
import com.halil.halil.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
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
        return new UserLoginResponseDto(jwtProvider.getAccessToken(user.getEmail()), jwtProvider.getRefreshToken());
    }

    @Override
    public UserResponseDto updateUserInfo(String email, UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new NotExistUserException());
        try{
            user.update(userUpdateRequestDto.getNickname());
            userRepository.save(user);
            UserResponseDto userResponseDto = new UserResponseDto(user);
            return userResponseDto;
        }catch (DataIntegrityViolationException e){
            throw new ExistNicknameException();
        }
    }

    @Override
    public void updateRefreshToken(String email, String refreshToken) {
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new NotExistUserException());
        user.updateRefreshToken(refreshToken);
        userRepository.save(user);
    }

    @Override
    public UserCreateResponseDto createUser(UserCreateRequestDto userCreateRequestDto) {
        User user = User.builder().email(userCreateRequestDto.getEmail()).nickname(userCreateRequestDto.getNickname()).build();
        userRepository.save(user);
        String accessToken = jwtProvider.getAccessToken( user.getEmail());
        String refreshToken = jwtProvider.getRefreshToken();
        return new UserCreateResponseDto(accessToken,refreshToken);
    }
}
