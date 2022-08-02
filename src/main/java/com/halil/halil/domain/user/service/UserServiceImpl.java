package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.dto.UserCreateResponseDto;
import com.halil.halil.domain.user.dto.UserResponseDto;
import com.halil.halil.domain.user.dto.UserUpdateRequestDto;
import com.halil.halil.domain.user.entity.User;
import com.halil.halil.domain.user.exception.ExistUserException;
import com.halil.halil.domain.user.repository.UserRepository;
import com.halil.halil.global.exception.ExistNicknameException;
import com.halil.halil.global.exception.NoExistUserException;
import com.halil.halil.global.util.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    @Override
    public UserResponseDto updateUserInfo(String email, UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NoExistUserException("존재하는 회원정보가 없습니다."));
        try{
            user.update(userUpdateRequestDto.getNickName());
            userRepository.save(user);
            UserResponseDto userResponseDto = new UserResponseDto(user);
            return userResponseDto;
        }catch (DataIntegrityViolationException e){
            throw new ExistNicknameException("존재하는 닉네임입니다.");
        }
    }

    @Override
    public void updateRefreshToken(String email, String refreshToken) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NoExistUserException("존재하는 회원정보가 없습니다."));
        user.updateRefreshToken(refreshToken);
        userRepository.save(user);
    }
    @Override
    public UserCreateResponseDto createUser(UserCreateRequestDto userCreateRequestDto){
        try {
            userRepository.save(userCreateRequestDto.toEntity());
            String accessToken = jwtProvider.createAccessToken(userCreateRequestDto.getNickName(), userCreateRequestDto.getEmail());
            String refreshToken = jwtProvider.createRefreshToken(userCreateRequestDto.getNickName(), userCreateRequestDto.getEmail());
            return new UserCreateResponseDto(accessToken, refreshToken);
        }catch (DataIntegrityViolationException e){
            throw new ExistUserException("Already Exist UserNickName");
        }
    }
}
