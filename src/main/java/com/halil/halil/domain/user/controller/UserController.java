package com.halil.halil.domain.user.controller;


import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.exception.ExistUserException;
import com.halil.halil.domain.user.service.UserService;
import com.halil.halil.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    ResponseEntity<CommonResponse> CreateUser(@RequestBody @Valid UserCreateRequestDto userCreateRequestDto){
        return new ResponseEntity<>(CommonResponse.createSuccess(userService.CreateUser(userCreateRequestDto)), HttpStatus.OK);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String invalidUserException(MethodArgumentNotValidException e){
        return "take a form";
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String nullTypeUserException(DataIntegrityViolationException e){
        return "Already Exist User";
    }
}