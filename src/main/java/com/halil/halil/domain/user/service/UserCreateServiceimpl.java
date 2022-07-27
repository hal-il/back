package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.entity.User;
import com.halil.halil.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class UserCreateServiceimpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public Optional<User> CreateUser(UserCreateRequestDto userCreateRequestDto){
        User user = new User().builder().email(userCreateRequestDto.getEmail()).nickName(userCreateRequestDto.getEmail()).build();
        userRepository.save(user);
        Optional<User> userid=userRepository.findById(user.getId());
        return userid;
    }
}
