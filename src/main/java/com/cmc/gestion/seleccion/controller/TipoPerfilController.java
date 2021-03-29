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
import com.cmc.gestion.seleccion.dao.TipoPerfilDao;
import com.cmc.gestion.seleccion.entity.SlTipoPerfil;

@RestController
@RequestMapping("/tipoPerfil")
public class TipoPerfilController {
	
	@Autowired
	private TipoPerfilDao tipoPerfilDao;
	
	@GetMapping
	public Iterable<SlTipoPerfil> listarTipoPerfil(){
		Iterable<SlTipoPerfil> resp = this.tipoPerfilDao.findAll();
		return resp;        
	}
	
	@PostMapping
	public SlTipoPerfil crearPerfil(@Valid @RequestBody SlTipoPerfil tipoPerfil) throws ControllerException {
		Optional<SlTipoPerfil>  optionalSlTipoPerfil = this.tipoPerfilDao.findById(tipoPerfil.getIdPerfil());
		if (optionalSlTipoPerfil.isPresent()) {
			new ControllerException("El tipo de perfil  existe");
			
		}
		
		return this.tipoPerfilDao.save(tipoPerfil);
		
	}
	
	@PutMapping("/{id}")
	public SlTipoPerfil actualizarPerfil(@Valid @RequestBody SlTipoPerfil tipoPerfil,  @PathVariable int id) {
		Optional<SlTipoPerfil> optionalSlTipoPerfil = this.tipoPerfilDao.findById(id);
		
		SlTipoPerfil resp = optionalSlTipoPerfil.get();
		
		resp.setNombre(tipoPerfil.getNombre());
		resp.setDescripcion(tipoPerfil.getDescripcion());
		
		return this.tipoPerfilDao.save(resp);
		
	}
	
	@DeleteMapping("/{id}")
	public void eliminarTipoPerfil(@PathVariable int id) {
		
		Optional<SlTipoPerfil> optionalSlTipoPerfil = this.tipoPerfilDao.findById(id);
		
		if (optionalSlTipoPerfil.isPresent()) {
			
			this.tipoPerfilDao.deleteById(id);
			
			
		}
	}
	
	
	
	
	

}
