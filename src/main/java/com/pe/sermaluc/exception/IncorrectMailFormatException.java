package com.pe.sermaluc.exception;

public class IncorrectMailFormatException extends RuntimeException{

    public IncorrectMailFormatException(String msg){
        super(msg);
    }
}
