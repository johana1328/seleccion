package com.cmc.gestion.seleccion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.gestion.seleccion.entity.Tarifa;

public interface TarifaDao extends JpaRepository<Tarifa, Integer> {

}
