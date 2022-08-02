package com.halil.halil.domain.user.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long user_id;

    @Column(name = "NICKNAME", unique = true, nullable = false)
    private String nickName;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @Builder
    public User( String nickname, String email){
        this.nickName = nickname;
        this.email = email;
    }

    public void update(String nickName){
        this.nickName = nickName;
    }

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
}