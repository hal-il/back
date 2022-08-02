package com.halil.halil.domain.login.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/login-form")
@RequiredArgsConstructor
public class LoginController {
    @Value("${google.oauth_uri}")
    private String GOOGLE_OAUTH_URI;

    @ApiOperation(value = "redirect to GOOGLE_OAUTH_URI", notes = "해당 api로 요청시 google 로그인 화면으로 리다이렉트 해줌")
    @ApiResponses({
            @ApiResponse(code = 302, message = "google 로그인 화면으로 redirect")
    })
    @GetMapping("/google")
    public void redirectGoogleRedirectUri(HttpServletResponse response) throws IOException {
        response.sendRedirect(GOOGLE_OAUTH_URI);
    }
}
