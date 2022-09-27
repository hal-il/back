package com.halil.halil.global.advice;

import com.halil.halil.domain.schedule.Exception.InvalidIdException;
import com.halil.halil.global.response.CommonResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class UserControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse> invalidDtoException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(CommonResponse.createError("take a Dto form plz"), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CommonResponse> ExistUserNickNameException(DataIntegrityViolationException e){
        return new ResponseEntity<>(CommonResponse.createError("Plz Check Dto Data"), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public  ResponseEntity<CommonResponse> EmptyDataDeleteException(EmptyResultDataAccessException e){
        return new ResponseEntity<>(CommonResponse.createError("Dont Delete Empty Entity"), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public  ResponseEntity<CommonResponse> EmptyEntityIdException(EntityNotFoundException e){
        return new ResponseEntity<>(CommonResponse.createError("Dont insert Empty Entity id"), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<CommonResponse> InvalidException(InvalidIdException e){
        return new ResponseEntity<>(CommonResponse.createError("Dont insert Invalid Id"), HttpStatus.BAD_REQUEST);
    }

}
