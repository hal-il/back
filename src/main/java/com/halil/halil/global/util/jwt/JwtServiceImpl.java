package com.halil.halil.global.util.jwt;

import com.halil.halil.domain.user.entity.User;
import com.halil.halil.domain.user.repository.UserRepository;
import io.jsonwebtoken.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.NoSuchElementException;

@Transactional
@Service
@RequiredArgsConstructor
@Setter(value = AccessLevel.PRIVATE)
public class JwtServiceImpl implements JwtService{

    @Value("${jwt.secret}")
    private String SECRET_KEY;
    @Value("${jwt.access.subject}")
    private String ACCESS_TOKEN_SUBJECT;
    @Value("${jwt.refresh.subject}")
    private String REFRESH_TOKEN_SUBJECT;

    private final UserRepository userRepository;

    @Override
    public String createAccessToken(String email) {
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setIssuer("Hans")
                .setSubject(ACCESS_TOKEN_SUBJECT)
                .setExpiration(new Date(now.getTime() + 1000 * 60L * 60L))
                .claim("email",email)
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY.getBytes())
                .compact();
    }

    @Override
    public String createRefreshToken() {
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setIssuer("Hans")
                .setSubject(REFRESH_TOKEN_SUBJECT)
                .setExpiration(new Date(now.getTime() + 1000 * 60L * 60L ))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY.getBytes())
                .compact();
    }

    @Override
    public boolean validateToken(String accessToken){
        Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(accessToken);
        return true;
    }

    @Override
    public String getEmailFromPayload(String accessToken){
        return Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(accessToken).getBody().get("email",String.class);
    }

    @Override
    public boolean compareRefreshToken(String refreshToken, String email){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("존재하는 회원정보가 없음."));
        String refreshTokenInDBMS = user.getRefreshToken();

        if(refreshToken.equals(refreshTokenInDBMS)){
            return true;
        }
        throw new IllegalArgumentException();
    }

}