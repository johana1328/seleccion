package com.cmc.gestion.seleccion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.gestion.seleccion.entity.SlCandidato;

public interface CandidatoDao extends JpaRepository<SlCandidato,String> {

}
