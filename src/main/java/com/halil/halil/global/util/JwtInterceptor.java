package com.halil.halil.global.util;

import com.halil.halil.domain.user.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class JwtInterceptor implements HandlerInterceptor  {
    private final JwtService jwtService;
    private final UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String accessToken = request.getHeader("Authorization").replace("Bearer ","");
        String refreshToken = request.getHeader("jwt-refresh-token");

        if("OPTIONS".equals(request.getMethod())){
            System.out.println("request method is OPTIONS");
            return true;
        }

        try{
            if(accessToken!=null){
                if(jwtService.validateToken(accessToken)){
                    String email = jwtService.getEmailFromPayload(accessToken);
                    request.setAttribute("email",email);
                    if(refreshToken != null) {
                        try{
                            if(jwtService.validateToken(refreshToken) && jwtService.compareRefreshToken(refreshToken,email)){
                                // Access Token 재발급
                                String newAccessToken = jwtService.createAccessToken(email);
                                response.setHeader("jwt-access-token",newAccessToken);

                                userService.updateRefreshToken(email, refreshToken);
                                return true;
                            }
                        }catch (IllegalArgumentException e){
                            throw new JwtException("유효하지 않은 Refresh Token 입니다.");
                        }catch (ExpiredJwtException e){
                            throw new JwtException("Refresh Token 기한이 만료되었습니다. 재로그인 하세요.");
                        }catch (SignatureException e){
                            throw new JwtException("Refresh Token의 사용자 인증이 실패하였습니다.");
                        }
                    }
                    else return true;
                }
                throw new JwtException("유효하지 않은 Access Token 입니다.");
            }else{
                response.sendRedirect("/google-login");
                response.setStatus(401);
                throw new IllegalArgumentException("로그인한 사용자만 접근가능합니다.");
            }
        }catch (IllegalArgumentException e) {
            throw new JwtException("유효하지 않은 Access Token 입니다.");
        }catch (ExpiredJwtException e){
            throw new JwtException("Access Token 기한이 만료되었습니다.");
        }catch (SignatureException e){
            throw new JwtException("Access Token의 사용자 인증이 실패하였습니다.");
        }

    }
}