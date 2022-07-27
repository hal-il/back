package com.halil.halil.domain.user.controller;


import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.service.UserService;
import com.halil.halil.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    ResponseEntity<CommonResponse> CreateUser(@RequestBody UserCreateRequestDto userCreateRequestDto){
        return new ResponseEntity<>(CommonResponse.createSuccess(userService.CreateUser(userCreateRequestDto)), HttpStatus.OK);
    }

}