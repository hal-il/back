package com.halil.halil.domain.user.repository;

import com.halil.halil.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByNickName(String nickName);
    Optional<User> findByEmail(String email);
}
