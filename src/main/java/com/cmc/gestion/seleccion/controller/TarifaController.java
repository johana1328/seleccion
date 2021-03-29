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
import com.cmc.gestion.seleccion.dao.TarifaDao;
import com.cmc.gestion.seleccion.entity.Tarifa;

@RestController
@RequestMapping("/tarifa")
public class TarifaController {
	
	@Autowired
	private TarifaDao tarifaDao;
	
	@GetMapping
	public Iterable<Tarifa> listarTarifa(){
		Iterable<Tarifa> resp = this.tarifaDao.findAll();
		return resp;
		
	}
	
	@PostMapping
	public Tarifa crearTarifa(@Valid @RequestBody Tarifa tarifa) throws ControllerException{
		Optional<Tarifa> optionalTarifa = this.tarifaDao.findById(tarifa.getIdTarifa());
		
	if (optionalTarifa.isPresent()) {
		new ControllerException("La tarifa ya existe");	
	}
	
	return this.tarifaDao.save(tarifa);
		
	}
	
	@PutMapping("/{id}")
	public Tarifa actualizarTarifa(@Valid @RequestBody Tarifa tarifa, @PathVariable int id) {
		Optional<Tarifa> optionalTarifa = this.tarifaDao.findById(id);
		
		Tarifa resp = optionalTarifa.get();
		
		resp.setValor(tarifa.getValor());
		
		return this.tarifaDao.save(resp);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarTarifa(@PathVariable int id) {
		
		Optional<Tarifa> optionalTarifa = this.tarifaDao.findById(id);
		
		if (optionalTarifa.isPresent()) {
			
			this.tarifaDao.deleteById(id);
			
		}
	}
	

}
