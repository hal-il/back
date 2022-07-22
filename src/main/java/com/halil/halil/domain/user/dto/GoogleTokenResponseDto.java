package com.halil.halil.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
public class GoogleTokenResponseDto {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Long expiresIn;
    @JsonProperty("refresh_token")
    private String refreshToken;
    private String scope;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("id_token")
    private String idToken;
}
