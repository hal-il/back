package com.halil.halil.domain.user;

import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.entity.User;
import com.halil.halil.domain.user.exception.ExistUserException;
import com.halil.halil.domain.user.repository.UserRepository;
import com.halil.halil.domain.user.service.UserCreateServiceimpl;
import com.halil.halil.domain.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserCreateServiceimpl userCreateServiceimpl;
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
        userCreateServiceimpl.CreateUser(userCreateRequestDto1);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> userCreateServiceimpl.CreateUser(dupUserCreateRequestDto));
    }
}