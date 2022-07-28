package com.halil.halil.domain.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long user_id;

    @Column(name = "NICKNAME", unique = true, nullable = false)
    private String nickname;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Builder
    public User( String nickname, String email){
        this.nickname = nickname;
        this.email = email;
    }

    public void update(String nickname){
        this.nickname = nickname;
    }

}
