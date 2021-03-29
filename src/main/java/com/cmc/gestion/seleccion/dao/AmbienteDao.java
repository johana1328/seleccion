package com.cmc.gestion.seleccion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.gestion.seleccion.entity.SlAmbiente;

public interface  AmbienteDao extends JpaRepository<SlAmbiente, Integer> {

}
