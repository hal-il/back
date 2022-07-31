package com.halil.halil.domain.user.controller;

import com.halil.halil.domain.user.dto.UserResponseDto;
import com.halil.halil.domain.user.dto.UserUpdateRequestDto;
import com.halil.halil.domain.user.service.UserService;
import com.halil.halil.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping()
    public ResponseEntity<?> updateUserInfo(HttpServletRequest request, @RequestBody @Valid UserUpdateRequestDto userUpdateRequestDto){
        String email = (String)request.getAttribute("email");
        UserResponseDto userResponseDto = userService.updateUserInfo(email,userUpdateRequestDto);
        return ResponseEntity.ok(CommonResponse.createSuccess(userResponseDto));
    }
}
