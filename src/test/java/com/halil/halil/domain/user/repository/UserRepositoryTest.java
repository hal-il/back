package com.halil.halil.domain.user.repository;

import com.halil.halil.domain.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void init(){
        userRepository.save(User.builder().email("test1@gmail.com").nickname("test1").build());
        userRepository.save(User.builder().email("test2@gmail.com").nickname("test2").build());
    }

    @Test
    @DisplayName("사용자는 중복된 닉네임으로 수정 할 수 없다.")
    void updateDuplicatedNickname(){
        User user = userRepository.findByEmail("test2@gmail.com").orElseThrow(() -> new NoSuchElementException());
        assertThrowsExactly(DataIntegrityViolationException.class, () -> {
            user.update("test1");
        });
    }
}