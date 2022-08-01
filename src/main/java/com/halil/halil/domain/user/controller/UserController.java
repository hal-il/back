package com.halil.halil.domain.user.controller;

import io.swagger.annotations.*;
import com.halil.halil.domain.user.dto.UserCreateRequestDto;
import com.halil.halil.domain.user.dto.UserCreateResponseDto;
import com.halil.halil.domain.user.dto.UserResponseDto;
import com.halil.halil.domain.user.dto.UserUpdateRequestDto;
import com.halil.halil.domain.user.service.UserService;
import com.halil.halil.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    private final UserService userService;

    @ApiOperation(value = "", notes = "해당 api로 요청시 google 로그인 화면으로 리다이렉트 해줌")
    @Validated
    @GetMapping
    ResponseEntity<CommonResponse> getUserByCode(@ApiParam(name = "code", type = "String", value = "구글 코드", example = "your code") @NotBlank @RequestParam("code") String code){
        return new ResponseEntity<>(CommonResponse.createSuccess(userService.findUserByCode(code)), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<CommonResponse> updateUserInfo(HttpServletRequest request, @RequestBody @Valid UserUpdateRequestDto userUpdateRequestDto){
        String email = (String)request.getAttribute("email");
        UserResponseDto userResponseDto = userService.updateUserInfo(email,userUpdateRequestDto);
        return ResponseEntity.ok(CommonResponse.createSuccess(userResponseDto));
    }

    @PostMapping("/create")
    ResponseEntity<CommonResponse> CreateUser(@RequestBody @Valid UserCreateRequestDto userCreateRequestDto){
        UserCreateResponseDto userCreateResponseDto = userService.CreateUser(userCreateRequestDto);
        return new ResponseEntity<>(CommonResponse.createSuccess(userCreateResponseDto), HttpStatus.OK);
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
