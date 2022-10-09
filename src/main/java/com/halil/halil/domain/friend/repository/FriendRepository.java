package com.halil.halil.domain.friend.repository;

import com.halil.halil.domain.friend.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    @Query("SELECT f FROM Friend f JOIN FETCH f.friend WHERE f.user.email = :email")
    List<Friend> findAllByUser_Email(String email);
}
