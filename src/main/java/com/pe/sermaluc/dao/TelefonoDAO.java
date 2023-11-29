package com.pe.sermaluc.dao;

import com.pe.sermaluc.entity.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonoDAO extends JpaRepository<Telefono,Integer> {

}
