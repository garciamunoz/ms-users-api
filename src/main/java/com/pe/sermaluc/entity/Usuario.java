package com.pe.sermaluc.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario implements Serializable {
    private static final long serialVersionUID = -2659530227289055796L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "creationdate")
    private String creationDate;
    @Column(name = "modifieddate")
    private String modifiedDate;
    @Column(name = "lastlogin")
    private String lastLogin;
    @Column(name = "token")
    private String token;
    @Column(name = "isactive")
    private boolean active;
    @Column(name = "pwd")
    private String pwd;
    @OneToMany(mappedBy="user")
    private List<Telefono> phones;

}

