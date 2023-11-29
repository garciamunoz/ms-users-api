package com.pe.sermaluc.business;

import com.pe.sermaluc.entity.Telefono;
import com.pe.sermaluc.entity.Usuario;
import com.pe.sermaluc.exception.AlreadyRegisteredEmailException;
import com.pe.sermaluc.exception.IncorrectMailFormatException;
import com.pe.sermaluc.model.Phone;
import com.pe.sermaluc.model.User;
import com.pe.sermaluc.dao.UsuarioDAO;
import com.pe.sermaluc.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

    @Autowired
    UsuarioDAO usuarioDao;
    @Autowired
    private Environment env;


    public UsuarioDTO registrarUsuario(String token, User user) {

        if(!user.getEmail().matches(env.getProperty("sermaluc.prueba.format.email"))){
            throw new IncorrectMailFormatException("Formato de correo incorrecto");
        }
        List<Usuario> testList = usuarioDao.buscarPorEmail(user.getEmail());
        if(testList!=null && !testList.isEmpty()){
            throw new AlreadyRegisteredEmailException("El correo ya registrado");
        }
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

        /**Once user is inserted proceed to register the phones*/
        for(Phone p:user.getListPhones()){
            Telefono t = new Telefono();
            t.setCityCode(p.getCityCode());
            t.setNumber(p.getNumber());
            t.setCityCode(p.getCityCode());
            t.setUser(u);
        }

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setCreated(u.getCreationDate());
        dto.setActive(u.isActive());
        dto.setLastLogin(u.getLastLogin());
        dto.setToken(u.getToken());
        dto.setModified(u.getModifiedDate());

        return dto;
    }
}
