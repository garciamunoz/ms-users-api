package com.pe.sermaluc.business;

import com.pe.sermaluc.model.User;
import com.pe.sermaluc.dao.UsuarioDAO;
import com.pe.sermaluc.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

    @Autowired
    UsuarioDAO usuarioDao;

    public UsuarioDTO registrarUsuario(String token, User user) {
        return null;
    }
}
