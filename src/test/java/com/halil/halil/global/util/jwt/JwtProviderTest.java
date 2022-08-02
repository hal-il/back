package com.halil.halil.global.util.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtProviderTest {
    private JwtProvider jwtProvider;

    @BeforeEach
    void before(){
        jwtProvider = new JwtProvider();
        jwtProvider.setSECRET_KEY("rightKey");
        jwtProvider.setExpiredTime(1000 * 60L);
    }

    @Test
    @DisplayName("사용자는 닉네임과 이메일을 가지고 jwt를 발급받을 수 있다")
    void getToken(){
        String email = "email";
        String nickName = "nickName";

        String jwt = jwtProvider.getToken(nickName, email);

        Claims claims = jwtProvider.parseToken(jwt);

        assertEquals(email, claims.get("email"));
        assertEquals(nickName, claims.get("nickName"));
        assertEquals("halil", claims.getIssuer());
    }

    @Test
    @DisplayName("시간이 지난 jwt 사용시 ExpiredJwtException error 발생")
    void generateExpiredException(){
        jwtProvider.setExpiredTime(0L);
        String email = "email";
        String nickName = "nickName";

        String jwt = jwtProvider.getToken(nickName, email);

        assertThrowsExactly(ExpiredJwtException.class, () -> {
            jwtProvider.parseToken(jwt);
        });
    }

    @Test
    @DisplayName("알맞지 않은 형식의 jwt일 경우 MalformedJwtException 발생")
    void generateException(){
        String email = "email";
        String nickName = "nickName";
        String wrongJwt = "wrongHeader.wrongPayload.wrongSignature";

        assertThrowsExactly(MalformedJwtException.class, () -> {
            jwtProvider.parseToken(wrongJwt);
        });
    }

    @Test
    @DisplayName("알맞지 않은 Signature로 서명시 SignatureException 발생")
    void wrongKeyJwt(){
        String email = "email";
        String nickName = "nickName";
        String wrongKey = "wrongKey";
        jwtProvider.setSECRET_KEY(wrongKey);
        String wrongJwt = jwtProvider.getToken(nickName, email);

        jwtProvider.setSECRET_KEY("rightKey");
        assertThrowsExactly(SignatureException.class, () -> {
            jwtProvider.parseToken(wrongJwt);
        });
    }
}