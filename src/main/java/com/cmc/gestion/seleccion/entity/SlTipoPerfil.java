package com.cmc.gestion.seleccion.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.List;


/**
 * The persistent class for the sl_tipo_perfil database table.
 * 
 */
@Entity
@Table(name="sl_tipo_perfil")
@NamedQuery(name="SlTipoPerfil.findAll", query="SELECT s FROM SlTipoPerfil s")
public class SlTipoPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SL_TIPO_PERFIL_IDPERFIL_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil")
	private int idPerfil;

	private String descripcion;
	
	@NotBlank(message = "El nombre es requerido")
	private String nombre;

	//bi-directional many-to-one association to SlSolicitudPersonal


	public SlTipoPerfil() {
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}