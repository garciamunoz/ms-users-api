package com.pe.sermaluc.dao;

import com.pe.sermaluc.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario,Integer> {
}
