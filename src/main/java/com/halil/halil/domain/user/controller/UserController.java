package com.halil.halil.domain.user.controller;

import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.dto.UserCreateResponseDto;
import com.halil.halil.domain.user.dto.UserResponseDto;
import com.halil.halil.domain.user.dto.UserUpdateRequestDto;
import com.halil.halil.domain.user.service.UserService;
import com.halil.halil.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/create")
    ResponseEntity<CommonResponse> createUser(@RequestBody @Valid UserCreateRequestDto userCreateRequestDto){
        UserCreateResponseDto userCreateResponseDto = userService.createUser(userCreateRequestDto);
        return new ResponseEntity<>(CommonResponse.createSuccess(userCreateResponseDto), HttpStatus.OK);
    }
}