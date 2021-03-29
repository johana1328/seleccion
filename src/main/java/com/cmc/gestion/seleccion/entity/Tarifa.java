package com.cmc.gestion.seleccion.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;



/**
 * The persistent class for the tarifa database table.
 * 
 */
@Entity
@Table(name="tarifa")
@NamedQuery(name="Tarifa.findAll", query="SELECT t FROM Tarifa t")
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TARIFA_IDTARIFA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tarifa")
	private int idTarifa;

	@NotBlank
	private String valor;

	//bi-directional many-to-one association to SlSolicitudPersonal
	

	public Tarifa() {
	}

	public int getIdTarifa() {
		return this.idTarifa;
	}

	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}