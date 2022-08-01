package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.dto.UserCreateResponseDto;
import com.halil.halil.domain.user.entity.User;
import com.halil.halil.domain.user.repository.UserRepository;
import com.halil.halil.global.util.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
@RequiredArgsConstructor
public class UserCreateServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    @Override
    public UserCreateResponseDto CreateUser(UserCreateRequestDto userCreateRequestDto){
        User user = new User().builder().email(userCreateRequestDto.getEmail()).nickName(userCreateRequestDto.getNickName()).build();
        userRepository.save(user);
        String accessToken = jwtProvider.createAccessToken(userCreateRequestDto.getNickName(), userCreateRequestDto.getEmail());
        String refreshToken = jwtProvider.createRefreshToken(userCreateRequestDto.getNickName(), userCreateRequestDto.getEmail());
        return new UserCreateResponseDto(accessToken,refreshToken);
    }
}
