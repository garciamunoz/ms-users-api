package com.pe.sermaluc.controller;

import com.google.gson.Gson;
import com.pe.sermaluc.business.UsuarioService;
import com.pe.sermaluc.dto.UsuarioDTO;
import com.pe.sermaluc.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {

    @Autowired
    Environment env;
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("create-user")
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody User usuario) {

        String token = getJWTToken(usuario.getName());
        UsuarioDTO user = usuarioService.registrarUsuario(token,usuario);
        return ResponseEntity.ok().body(user);

    }

    private String getJWTToken(String username) {
        String secretKey = env.getProperty("sermaluc.prueba.secret.key");
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
