package com.halil.halil.global.exceptionhanlder;

import com.halil.halil.domain.user.exception.NotExistUserException;
import com.halil.halil.global.common.CommonResponse;
import com.halil.halil.global.util.jwt.InvalidAccessTokenException;
import com.halil.halil.global.util.jwt.InvalidRefreshTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerUtil {
    @ExceptionHandler(NotExistUserException.class)
    public ResponseEntity<CommonResponse> handleNotExistUserException(NotExistUserException e){
        return new ResponseEntity<>(CommonResponse.createError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse> handleMethodArgumentNotValidException(BindingResult bindingResult){
        return new ResponseEntity<>(CommonResponse.createFail(bindingResult), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidAccessTokenException.class)
    public ResponseEntity<CommonResponse> handleInvalidAccessTokenException(InvalidAccessTokenException e){
        return new ResponseEntity<>(CommonResponse.createError(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidRefreshTokenException.class)
    public ResponseEntity<CommonResponse> handleInvalidRefreshTokenException(InvalidRefreshTokenException e){
        return new ResponseEntity<>(CommonResponse.createError(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
