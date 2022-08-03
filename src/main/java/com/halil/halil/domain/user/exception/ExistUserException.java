package com.halil.halil.domain.user.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class ExistUserException extends DataIntegrityViolationException {
    public ExistUserException(){
        super("Already Exist User!");
    }
}