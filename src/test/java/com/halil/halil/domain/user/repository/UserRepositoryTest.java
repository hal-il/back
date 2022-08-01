package com.halil.halil.domain.user.repository;

import com.halil.halil.domain.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @BeforeEach
    void init(){
        userRepository.save(User.builder().email("hello@gmail.com").nickname("hello").build());
        userRepository.save(User.builder().email("world@gmail.com").nickname("world").build());
    }
    @Test
    void findUserByNickname(){
        User user = userRepository.findUserByEmail("hello@gmail.com").get();
        assertEquals("hello",user.getNickname());
    }

}