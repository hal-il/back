package com.halil.halil.domain.user.controller;

import com.halil.halil.domain.user.dto.UserUpdateRequestDto;
import com.halil.halil.domain.user.exception.ExistNicknameException;
import com.halil.halil.domain.user.service.UserService;
import com.halil.halil.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping()
    public ResponseEntity<?> updateUserInfo(@RequestBody @Valid UserUpdateRequestDto userUpdateRequestDto){
        try{
            return ResponseEntity.ok(CommonResponse.createSuccess(userService.updateUserInfo(userUpdateRequestDto)));
        }catch (DataIntegrityViolationException e){
            throw new ExistNicknameException("이미 존재하는 닉네임입니다.");
        }
    }
}
