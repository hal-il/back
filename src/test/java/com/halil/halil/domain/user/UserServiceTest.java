package com.halil.halil.domain.user;

import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.entity.User;
import com.halil.halil.domain.user.repository.UserRepository;
import com.halil.halil.domain.user.service.UserCreateServiceimpl;
import com.halil.halil.domain.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    @DisplayName("create function test")
    void CreateWellTest(){
        final User user = User.builder().email(userCreateRequestDto1.getEmail())
                .nickName(userCreateRequestDto1.getNickName()).build();
        Optional<User> userid=userCreateServiceimpl.CreateUser(userCreateRequestDto1);
        System.out.println(userid);
    }
}