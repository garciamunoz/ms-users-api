package com.pe.sermaluc.controller;

import com.pe.sermaluc.exception.AlreadyRegisteredEmailException;
import com.pe.sermaluc.exception.IncorrectMailFormatException;
import com.pe.sermaluc.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMensaje(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
