package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.UserResponseDto;
import com.halil.halil.domain.user.dto.UserUpdateRequestDto;
import com.halil.halil.domain.user.entity.User;
import com.halil.halil.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public UserResponseDto updateUserInfo(UserUpdateRequestDto userUpdateRequestDto) {
        String email = userUpdateRequestDto.getEmail();
        String nickname = userUpdateRequestDto.getNickname();

        User user = userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException());
        user.update(nickname);

        userRepository.save(user);

        UserResponseDto userResponseDto = new UserResponseDto(user);
        return userResponseDto;
    }

}
