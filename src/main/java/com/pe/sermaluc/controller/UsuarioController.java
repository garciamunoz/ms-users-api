package com.pe.sermaluc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ms-users-api/v1")
public class UsuarioController {


    @GetMapping(value = "/hola", produces = "application/json")
    public String hello(){
        return  "hola";
    }
}
