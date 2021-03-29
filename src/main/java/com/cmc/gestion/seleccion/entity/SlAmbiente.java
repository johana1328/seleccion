package com.cmc.gestion.seleccion.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;



/**
 * The persistent class for the sl_ambiente database table.
 * 
 */
@Entity
@Table(name="sl_ambiente")
@NamedQuery(name="SlAmbiente.findAll", query="SELECT s FROM SlAmbiente s")
public class SlAmbiente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SL_AMBIENTE_IDAMBIENTE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ambiente")
	private int idAmbiente;

	private String descripcion;

	@NotBlank(message = "El nombre es requerido")
	private String nombre;

	//bi-directional many-to-one association to SlSolicitudPersonal
	
	public SlAmbiente() {
	}

	public int getIdAmbiente() {
		return this.idAmbiente;
	}

	public void setIdAmbiente(int idAmbiente) {
		this.idAmbiente = idAmbiente;
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