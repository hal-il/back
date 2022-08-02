package com.halil.halil.domain.user.controller;

import com.halil.halil.domain.user.service.UserServiceImpl;
import io.swagger.annotations.*;
import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.dto.UserUpdateRequestDto;
import com.halil.halil.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotBlank;
import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

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

    @PutMapping
    public ResponseEntity<CommonResponse> updateUserInfo(HttpServletRequest request, @RequestBody @Valid UserUpdateRequestDto userUpdateRequestDto){
        return ResponseEntity.ok(CommonResponse.createSuccess(userService.updateUserInfo((String) request.getAttribute("email"),userUpdateRequestDto)));
    }

    @PostMapping("/create")
    ResponseEntity<CommonResponse> createUser(@RequestBody @Valid UserCreateRequestDto userCreateRequestDto){
        return new ResponseEntity<>(CommonResponse.createSuccess(userService.createUser(userCreateRequestDto)), HttpStatus.OK);
    }
}
