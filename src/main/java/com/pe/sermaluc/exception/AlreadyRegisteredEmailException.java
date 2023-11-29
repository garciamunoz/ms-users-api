package com.pe.sermaluc.exception;

public class AlreadyRegisteredEmailException extends RuntimeException{

    public AlreadyRegisteredEmailException(String msg){
        super(msg);
    }
}
