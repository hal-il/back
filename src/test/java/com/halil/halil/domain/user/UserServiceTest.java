package com.halil.halil.domain.user;

import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.repository.UserRepository;
import com.halil.halil.domain.user.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserServiceImpl userCreateServiceImpl;
    @Autowired
    private UserRepository userRepository;

    private UserCreateRequestDto userCreateRequestDto1 = new UserCreateRequestDto("email1","nickname1");
    private UserCreateRequestDto userCreateRequestDto2 = new UserCreateRequestDto("email2","nickname2");
    private UserCreateRequestDto userCreateRequestDto3 = new UserCreateRequestDto("email3","nickname3");
    void Setup(){

    }
    @Test
    @DisplayName("Already Exist User Exception Test")
    void AlreadyExistUserTest(){
        UserCreateRequestDto dupUserCreateRequestDto = new UserCreateRequestDto("email1","nickname1");
        userCreateServiceImpl.createUser(userCreateRequestDto1);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> userCreateServiceImpl.createUser(dupUserCreateRequestDto));
    }
    @Test
    @DisplayName("No nickName in User Test")
    void NotExistUserNameTest(){
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto("nickname",null);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> userCreateServiceImpl.createUser(userCreateRequestDto));
    }
}