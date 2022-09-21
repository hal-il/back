package com.halil.halil.global.util.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class AccessTokenInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(request.getMethod().equals(HttpMethod.OPTIONS)) return true;
        try {
            String accessToken = parseHeader(request.getHeader(HttpHeaders.AUTHORIZATION));
            jwtProvider.isValidateToken(accessToken);
            request.setAttribute("email", jwtProvider.getEmail(accessToken));
        }catch (Exception e){
            throw new InvalidAccessTokenException();
        }
        return true;
    }

    private String parseHeader(String authorizaionHeader) throws Exception{
        return authorizaionHeader.split(" ")[1];
    }
}
