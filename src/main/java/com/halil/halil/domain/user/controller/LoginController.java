package com.halil.halil.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    @Value("${google.redirect_uri}")
    private String GOOGLE_REDIRECT_URI;

    @GetMapping("/google")
    public void redirectGoogleRedirectUri(HttpServletResponse response) throws IOException {
        response.sendRedirect(GOOGLE_REDIRECT_URI);
    }
}
