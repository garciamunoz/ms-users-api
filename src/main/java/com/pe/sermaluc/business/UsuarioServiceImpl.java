package com.pe.sermaluc.business;

import com.pe.sermaluc.entity.Usuario;
import com.pe.sermaluc.model.User;
import com.pe.sermaluc.dao.UsuarioDAO;
import com.pe.sermaluc.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

    @Autowired
    UsuarioDAO usuarioDao;

    public UsuarioDTO registrarUsuario(String token, User user) {
        Usuario usuarioBD = new Usuario();
        usuarioBD.setActive(true);
        usuarioBD.setEmail(user.getEmail());
        usuarioBD.setToken(token);
        usuarioBD.setUserName(user.getName());
        Date today = new Date();
        Timestamp ts = new Timestamp(today.getTime());
        usuarioBD.setCreationDate(""+ts);
        usuarioBD.setModifiedDate(""+ts);
        usuarioBD.setLastLogin(""+ts);
        String pwdEncripted = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
        usuarioBD.setPwd(pwdEncripted);
        Usuario u = usuarioDao.save(usuarioBD);
        return null;
    }
}
