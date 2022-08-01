package com.halil.halil.domain.user.repository;

import com.halil.halil.domain.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void init(){
        userRepository.save(User.builder().nickName("nickName1").email("email1").build());
        userRepository.save(User.builder().nickName("nickName2").email("email2").build());
        userRepository.save(User.builder().nickName("nickName3").email("email3").build());
        userRepository.save(User.builder().email("test1@gmail.com").nickname("test1").build());
        userRepository.save(User.builder().email("test2@gmail.com").nickname("test2").build());
    }

    @Test
    @DisplayName("사용자는 중복된 이메일을 넣을 수 없다.")
    void duplicatedEmail(){
        String duplicateEmail = "email1";
        assertThrowsExactly(DataIntegrityViolationException.class, () -> {
            userRepository.save(User.builder().nickName("nickName4").email(duplicateEmail).build());
        });
    }

    @Test
    @DisplayName("사용자는 중복된 닉네임을 넣을 수 없다.")
    void duplicatedNickName(){
        String duplicateNickName = "nickName1";
        assertThrowsExactly(DataIntegrityViolationException.class, () -> {
            userRepository.save(User.builder().nickName(duplicateNickName).email("email4").build());
        });
    }

    @Test
    @DisplayName("이메일로 사용자를 조회할 수 있다.")
    void findUserByEmail(){
        String email = "email1";
        String targetNickName = "nickName1";
        assertEquals(targetNickName, userRepository.findUserByEmail(email).get().getNickName());
    }

    @Test
    @DisplayName("없는 이메일로 사용자를 조회할 경우")
    void findUserByNotExistedEmail(){
        String notExistedEmail = "notExistedEmail";
        assertEquals(false, userRepository.findUserByEmail(notExistedEmail).isPresent());
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