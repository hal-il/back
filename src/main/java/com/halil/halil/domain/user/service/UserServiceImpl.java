package com.halil.halil.domain.user.service;

import com.halil.halil.domain.user.dto.GoogleTokenResponseDto;
import com.halil.halil.domain.user.dto.GoogleUserInfoResponseDto;
import com.halil.halil.domain.user.dto.UserLoginResponseDto;
import com.halil.halil.domain.user.entity.User;
import com.halil.halil.domain.user.exception.NotExistUserException;
import com.halil.halil.domain.user.repository.UserRepository;
import com.halil.halil.global.util.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Value("${google.client_id}")
    private String GOOGLE_CLIENT_ID;

    @Value("${google.client_secret}")
    private String GOOGLE_CLIENT_SECRET;

    @Value("${google.redirect_uri}")
    private String GOOGLE_REDIRECT_URI;

    @Value("authorization_code")
    private String GOOGLE_GRANT_TYPE;

    private final UserRepository userRepository;

    private final JwtProvider jwtProvider;

    @Override
    public UserLoginResponseDto findUserByCode(String code) {
        GoogleTokenResponseDto googleTokenResponseDto = getAccessTokenFromGoogleApi(code);
        String email = getGoogleEmailFromGoogleApi(googleTokenResponseDto.getAccessToken());
        Optional<User> user = userRepository.findUserByEmail(email);

        if(!user.isPresent()){
            throw new NotExistUserException("사용자가 존재하지 않음");
        }
        return new UserLoginResponseDto(jwtProvider.getToken(user.get().getNickName(), user.get().getEmail()));
    }

    private GoogleTokenResponseDto getAccessTokenFromGoogleApi(String code){
        URI uri = UriComponentsBuilder.fromUriString("https://www.googleapis.com")
                .path("/oauth2/v4/token")
                .encode()
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("client_id", GOOGLE_CLIENT_ID);
        params.add("client_secret", GOOGLE_CLIENT_SECRET);
        params.add("redirect_uri", GOOGLE_REDIRECT_URI);
        params.add("grant_type", GOOGLE_GRANT_TYPE);

        HttpEntity<MultiValueMap<String, String>> restRequest = new HttpEntity<>(params, headers);

        return new RestTemplate().postForEntity(uri, restRequest, GoogleTokenResponseDto.class).getBody();
    }

    private String getGoogleEmailFromGoogleApi(String accessToken){
        URI uri = UriComponentsBuilder.fromUriString("https://www.googleapis.com")
                .path("/oauth2/v2/userinfo")
                .encode()
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        HttpEntity<HttpHeaders> request = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(uri, HttpMethod.GET, request, GoogleUserInfoResponseDto.class).getBody().getEmail();
    }
}
