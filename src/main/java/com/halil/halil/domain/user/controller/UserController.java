package com.halil.halil.domain.user.controller;

import com.halil.halil.domain.user.dto.UserLoginResponseDto;
import com.halil.halil.domain.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping
    ResponseEntity<UserLoginResponseDto> getUserByCode(@RequestParam("code") String code){
        return new ResponseEntity<>(userService.findUserByCode(code), HttpStatus.OK);
    }
}
