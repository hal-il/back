package com.halil.halil.domain.user.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "USERS")
@NoArgsConstructor
@Getter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="USER_ID")
    //@GeneratedValue(?)
    private long user_id;
    @Column(name ="NICKNAME", nullable = false)
    private String nickname;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Builder
    public User( String nickname, String email){
        this.nickname = nickname;
        this.email = email;
    }
}
