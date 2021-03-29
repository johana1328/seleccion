package com.cmc.gestion.seleccion.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;



/**
 * The persistent class for the sl_candidato database table.
 * 
 */
@Entity
@Table(name="sl_candidato")
@NamedQuery(name="SlCandidato.findAll", query="SELECT s FROM SlCandidato s")
public class SlCandidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank(message = "El documento es requerido")
	@NotEmpty 
	@Positive(message = "El documento debe ser positivo")
	private String cedula;

	@NotBlank(message = "Los apellidos son reuqeridos")
	private String apellidos;

	@Column(name="aspiracion_salarial")
	private double aspiracionSalarial;

	
	@NotBlank(message = "El correo electronico es requerido")
	@Email(message = "El correo no esta bien escrito")
	@Column(name="correo_electronico")
	private String correoElectronico;

	@NotNull(message = "La disponibilidad es requerida")
	private int disponibilidad;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	private String gestor;
	
	@NotBlank(message = "El nombre es requerido")
	private String nombres;

	@NotBlank(message = "Los objetivos son reuqridos")
	private String objetivos;

	private String observaciones;

	@Column(name="proceso_documental")
	private int procesoDocumental;

	@Column(name="salario_actual")
	private double salarioActual;

	@Column(name="salario_flexible")
	private byte salarioFlexible;

	@NotEmpty(message = "El teléfono es requerido")
	private String telefono;

	@Column(name="tipo_contrato")
	private String tipoContrato;

	@NotBlank(message = "El titulo profesional es requerido")
	@Column(name="titulo_profesional")
	private String tituloProfesional;
	
	@NotNull(message = "El campo es requerido")
	@Column(name="trabaja_actual")
	private byte trabajaActual;

	//bi-directional many-to-one association to SlProceso
	

	public SlCandidato() {
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public double getAspiracionSalarial() {
		return this.aspiracionSalarial;
	}

	public void setAspiracionSalarial(double aspiracionSalarial) {
		this.aspiracionSalarial = aspiracionSalarial;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public int getDisponibilidad() {
		return this.disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getGestor() {
		return this.gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getObjetivos() {
		return this.objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getProcesoDocumental() {
		return this.procesoDocumental;
	}

	public void setProcesoDocumental(int procesoDocumental) {
		this.procesoDocumental = procesoDocumental;
	}

	public double getSalarioActual() {
		return this.salarioActual;
	}

	public void setSalarioActual(double salarioActual) {
		this.salarioActual = salarioActual;
	}

	public byte getSalarioFlexible() {
		return this.salarioFlexible;
	}

	public void setSalarioFlexible(byte salarioFlexible) {
		this.salarioFlexible = salarioFlexible;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoContrato() {
		return this.tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getTituloProfesional() {
		return this.tituloProfesional;
	}

	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}

	public byte getTrabajaActual() {
		return this.trabajaActual;
	}

	public void setTrabajaActual(byte trabajaActual) {
		this.trabajaActual = trabajaActual;
	}

	

}