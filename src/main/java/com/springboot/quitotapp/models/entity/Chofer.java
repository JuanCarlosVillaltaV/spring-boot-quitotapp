package com.springboot.quitotapp.models.entity;

import java.io.Serializable;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="choferes")
public class Chofer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer idChofer;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	private String cedula;
	@NotEmpty
	private String celular;
	@NotEmpty
	@Email
	private String correo;
	@NotNull
	private Integer estadoRegistro;
	
	 //Relación tabla intermedia
	 @ManyToMany(mappedBy = "choferes")
	 private List<Unidad> unidades;
	//Relación tabla intermedia fin
	
	
	
	
	public Integer getIdChofer() {
		return idChofer;
	}
	public void setIdChofer(Integer idChofer) {
		this.idChofer = idChofer;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	@Override
	public String toString() {
		return "Chofer [idChofer=" + idChofer + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", celular=" + celular + ", correo=" + correo + ", estadoRegistro=" + estadoRegistro + "]";
	}
	
	
}
