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

    private Long expiredTime = 1000 * 60L;

    public String getToken(String nickName, String email){
        Date now = new Date();
        return Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("halil")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expiredTime))
                .claim("nickName", nickName)
                .claim("email", email)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }

    public Claims parseToken(String jwt) throws ExpiredJwtException, MalformedJwtException, SignatureException {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes())
                .parseClaimsJws(jwt)
                .getBody();
    }
}
