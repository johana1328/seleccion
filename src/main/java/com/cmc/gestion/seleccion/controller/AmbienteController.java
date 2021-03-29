package com.cmc.gestion.seleccion.controller;

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
import com.cmc.gestion.seleccion.dao.AmbienteDao;
import com.cmc.gestion.seleccion.entity.SlAmbiente;
import com.cmc.gestion.seleccion.entity.SlCandidato;

@RestController
@RequestMapping("/ambiente")
public class AmbienteController {
	
	@Autowired
	private AmbienteDao ambienteDao;
	
	@GetMapping
	public Iterable<SlAmbiente> listarAmbiente(){
		Iterable<SlAmbiente> resp  = this.ambienteDao.findAll();
		return resp;
	}
	
	@PostMapping
	public SlAmbiente crearAmbiente(@Valid @RequestBody SlAmbiente ambiente)  throws ControllerException{
		Optional<SlAmbiente> optionalSlAmbiente = this.ambienteDao.findById(ambiente.getIdAmbiente());
		if (optionalSlAmbiente.isPresent()) {
			new ControllerException("El ambiente existe");
		}
		SlAmbiente resp =  this.ambienteDao.save(ambiente);
		return resp;
		
	}
	
	@PutMapping("/{id}")
	public SlAmbiente actualizarAmbiente(@Valid @RequestBody SlAmbiente ambiente, @PathVariable int id) {
		Optional<SlAmbiente> optionalSlAmbiente = this.ambienteDao.findById(id);
		SlAmbiente resp = optionalSlAmbiente.get();
		
		resp.setNombre(ambiente.getNombre());
		resp.setDescripcion(ambiente.getDescripcion());
		
		return this.ambienteDao.save(resp);
		
	}
	@DeleteMapping("/{id}")
	public void eliminarAmbiente(@PathVariable int id) {
		Optional<SlAmbiente> optionalSlAmbiente = this.ambienteDao.findById(id);
		if (optionalSlAmbiente.isPresent()) {
			this.ambienteDao.deleteById(id);
			
		}
	}

}
