package com.halil.halil.domain.user.service;

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
    public User updateUserInfo(UserUpdateRequestDto userUpdateRequestDto) {
        String email = userUpdateRequestDto.getEmail();
        String nickname = userUpdateRequestDto.getNickname();
        System.out.println("email : " + email);
        System.out.println("nickname : " + nickname);
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException());
        user.update(nickname);
        System.out.println("user : "+user);
        userRepository.save(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException());
        return user;
    }


}
