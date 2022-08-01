package com.halil.halil.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickName;

    @Column(nullable = false, unique = true)
    private String email;

    @Builder
    public User(String nickName, String email){
        this.nickName = nickName;
        this.email = email;
    }
}