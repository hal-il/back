package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.entity.User;
import com.halil.halil.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class UserCreateServiceimpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public Optional<User> CreateUser(UserCreateRequestDto userCreateRequestDto){
        /*Optional<User> findUsers = userRepository.findUserByEmail(userCreateRequestDto.getEmail());
        if(!findUsers.isEmpty()){
            throw new ExistUserNameException("이미 존재하는 사용자");
        }
        findUsers = userRepository.findUserByNickName(userCreateRequestDto.getNickName());
        if(!findUsers.isEmpty()){
            throw new ExistUserNameException("이미 존재하는 사용자");
        }*/
        User user = new User().builder().email(userCreateRequestDto.getEmail()).nickName(userCreateRequestDto.getNickName()).build();
        userRepository.save(user);
        Optional<User> searchUser=userRepository.findById(user.getId());
        return searchUser;
    }
}
