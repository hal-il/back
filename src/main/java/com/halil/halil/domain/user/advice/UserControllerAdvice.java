package com.halil.halil.domain.user.advice;

import com.halil.halil.global.response.CommonResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {
    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse> invalidDtoException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(CommonResponse.createError("take a form plz"), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CommonResponse> ExistUserNickNameException(DataIntegrityViolationException e){
        return new ResponseEntity<>(CommonResponse.createError("Already Exist NickName"), HttpStatus.BAD_REQUEST);
    }*/

}
