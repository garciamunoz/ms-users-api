package com.pe.sermaluc.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsuarioDTO implements Serializable {


    private static final long serialVersionUID = 6668621505719707518L;

    private Integer id;
    private String created;
    private String modified;
    private String lastLogin;
    private String token;
    private boolean active;
}
