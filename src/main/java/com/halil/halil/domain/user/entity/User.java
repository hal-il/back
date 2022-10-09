package com.halil.halil.domain.user.entity;


import com.halil.halil.domain.friend.entity.Friend;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "NICKNAME", unique = true, nullable = false)
    private String nickname;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Friend> friends = new ArrayList<>();

    @Builder
    public User( String nickname, String email){
        this.nickname = nickname;
        this.email = email;
    }

    public void update(String nickname){
        this.nickname = nickname;
    }

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
}