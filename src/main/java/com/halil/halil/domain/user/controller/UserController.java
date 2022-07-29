package com.halil.halil.domain.user.controller;

import com.halil.halil.domain.user.service.UserServiceImpl;
import com.halil.halil.global.common.CommonResponse;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserServiceImpl userService;

    @ApiOperation(value = "", notes = "해당 api로 요청시 google 로그인 화면으로 리다이렉트 해줌")
    @Validated
    @GetMapping
    ResponseEntity<CommonResponse> getUserByCode(@ApiParam(name = "code", type = "String", value = "구글 코드", example = "your code") @NotBlank @RequestParam("code") String code){
        return new ResponseEntity<>(CommonResponse.createSuccess(userService.findUserByCode(code)), HttpStatus.OK);
    }
}
