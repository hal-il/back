package com.halil.halil.global.util.jwt;

import io.jsonwebtoken.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Setter
public class JwtProvider {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String createAccessToken(String nickName, String email) {
        Long tokenInvalidTime = 1000L * 60 * 3; // 3m
        return this.createToken(email, nickName, tokenInvalidTime);
    }

    public String createRefreshToken(String nickName, String email) {
        Long tokenInvalidTime = 1000L * 60 * 60 * 24; // 1d
        String refreshToken = this.createToken(nickName, email, tokenInvalidTime);
        return refreshToken;
    }

    private String createToken(String nickName, String email, Long tokenInvalidTime){
        Date date = new Date();
        return Jwts.builder().setIssuer("halil")
                .claim("nickName",nickName)
                .claim("email",email)
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + tokenInvalidTime))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
