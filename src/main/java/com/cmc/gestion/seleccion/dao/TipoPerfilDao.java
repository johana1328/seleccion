package com.cmc.gestion.seleccion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.gestion.seleccion.entity.SlTipoPerfil;

public interface TipoPerfilDao extends JpaRepository<SlTipoPerfil, Integer> {

}
