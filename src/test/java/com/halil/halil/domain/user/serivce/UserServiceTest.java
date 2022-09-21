package com.halil.halil.domain.user.serivce;

import com.halil.halil.domain.login.service.LoginService;
import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.dto.UserCreateResponseDto;
import com.halil.halil.domain.user.entity.User;
import com.halil.halil.domain.user.exception.ExistNicknameException;
import com.halil.halil.domain.user.repository.UserRepository;
import com.halil.halil.domain.user.service.UserServiceImpl;
import com.halil.halil.global.util.jwt.JwtProvider;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class UserServiceTest {

    private UserServiceImpl userService;

    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    private JwtProvider jwtProvider = Mockito.mock(JwtProvider.class);
    private LoginService loginService = Mockito.mock(LoginService.class);

    @BeforeEach
    void init(){
        userService = new UserServiceImpl(userRepository, jwtProvider, loginService);
    }

    @Test
    @DisplayName("중복 회원 가입")
    void duplicatedSignUpTest(){
        String duplicatedNickName = "duplicatedNickName";
        String duplicatedEmail = "duplicatedEmail";
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto();
        userCreateRequestDto.setEmail(duplicatedEmail);
        userCreateRequestDto.setNickname(duplicatedNickName);

        Mockito.when(userRepository.save(any(User.class))).thenThrow(new ExistNicknameException());

        Assertions.assertThrows(ExistNicknameException.class, () -> userService.createUser(userCreateRequestDto));
        verify(userRepository).save(any(User.class));
    }

    @Test
    @DisplayName("회원 가입 성공")
    void successSignUpTest(){
        String nickname = "nickName";
        String email = "email";
        String accessToken = "accessToken";
        String refreshToken = "refreshToken";
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto();
        userCreateRequestDto.setNickname(nickname);
        userCreateRequestDto.setEmail(email);

        UserCreateResponseDto userCreateResponseDto = new UserCreateResponseDto(accessToken, refreshToken);

        Mockito.when(jwtProvider.getAccessToken(email)).thenReturn("accessToken");
        Mockito.when(jwtProvider.getRefreshToken()).thenReturn("refreshToken");

        Assertions.assertEquals(userCreateResponseDto.getAccessToken(), userService.createUser(userCreateRequestDto).getAccessToken());
        Assertions.assertEquals(userCreateResponseDto.getRefreshToken(), userService.createUser(userCreateRequestDto).getRefreshToken());
    }

    @Test
    @DisplayName("닉네임 조회 실패")
    void notExistUserNickNameTest(){

    }
}