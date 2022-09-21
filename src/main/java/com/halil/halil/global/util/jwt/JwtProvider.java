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

    private Long accessTokenExpiredTime = 1000L * 60 * 60;

    private Long refreshTokenExpiredTime = 1000L * 60 * 60 * 24 * 14;

    public String getAccessToken(String email){
        Date now = new Date();
        return Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("halil")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + accessTokenExpiredTime))
                .claim("email", email)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }

    public String getRefreshToken(){
        Date now = new Date();
        return Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("halil")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + refreshTokenExpiredTime))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }

    public boolean isValidateToken(String token){
        Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token).getBody();
        return true;
    }

    public String getEmail(String accessToken){
        return (String) Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes())
                .parseClaimsJws(accessToken)
                .getBody().get("email");
    }
}
