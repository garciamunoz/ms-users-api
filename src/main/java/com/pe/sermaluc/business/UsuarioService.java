package com.pe.sermaluc.business;


import com.pe.sermaluc.bean.User;

import com.pe.sermaluc.dto.UsuarioDTO;

public interface UsuarioService {


    public UsuarioDTO registrarUsuario(String token, User user);


}
