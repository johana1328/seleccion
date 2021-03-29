package com.cmc.gestion.seleccion.controller;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.gestion.seleccion.ControllerException;
import com.cmc.gestion.seleccion.dao.CandidatoDao;
import com.cmc.gestion.seleccion.entity.SlCandidato;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

	@Autowired
	private CandidatoDao candidatoDao;

	@GetMapping
	public Iterable<SlCandidato> listarCandidato() {
		Iterable<SlCandidato> resp = this.candidatoDao.findAll();
		return resp;

	}

	@PostMapping
	public SlCandidato crearCandidato(@Valid @RequestBody SlCandidato candidato) throws ControllerException {
		Optional<SlCandidato> optionalSlCandidato = this.candidatoDao.findById(candidato.getCedula());
		if (optionalSlCandidato.isPresent()) {
			throw new ControllerException("El candidato se encuentra resgistrado");
		}
		candidato.setFechaActualizacion(new Date());
		candidato.setEstado("CAIW");
		candidato.setFechaCreacion(new Date());
		candidato.setProcesoDocumental(1);
		candidato.setGestor("");
		candidato.setObservaciones("");
		SlCandidato resp = this.candidatoDao.save(candidato);
		return resp;

	}

	@PutMapping("/{cedula}")
	public SlCandidato actualizarCandidato(@Valid @RequestBody SlCandidato candidato, @PathVariable String cedula) {
		Optional<SlCandidato> optionalSlCandidato = this.candidatoDao.findById(cedula);
		SlCandidato resp = optionalSlCandidato.get();

		resp.setNombres(candidato.getNombres());
		resp.setApellidos(candidato.getApellidos());
		resp.setTelefono(candidato.getTelefono());
		resp.setCorreoElectronico(candidato.getCorreoElectronico());
		resp.setTituloProfesional(candidato.getTituloProfesional());
		resp.setTrabajaActual(candidato.getTrabajaActual());
		resp.setSalarioActual(candidato.getSalarioActual());
		resp.setTipoContrato(candidato.getTipoContrato());
		resp.setAspiracionSalarial(candidato.getAspiracionSalarial());
		resp.setSalarioFlexible(candidato.getSalarioFlexible());
		resp.setDisponibilidad(candidato.getDisponibilidad());
		resp.setObjetivos(candidato.getObjetivos());
		resp.setFechaActualizacion(new Date());

		return this.candidatoDao.save(resp);
	}
	
	@DeleteMapping("/{cedula}")
	public void eliminarCandidato(@PathVariable String cedula) {
		Optional<SlCandidato> optionalSlCandidato = this.candidatoDao.findById(cedula);
		if (optionalSlCandidato.isPresent() ) {
			this.candidatoDao.deleteById(cedula);
			
		}
		
	}

}
