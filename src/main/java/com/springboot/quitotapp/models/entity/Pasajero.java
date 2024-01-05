package com.springboot.quitotapp.models.entity;

import java.io.Serializable;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "pasajeros")
public class Pasajero implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer idPasajero;
	@NotEmpty
	private String cedula;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	private String telefono;
	@NotEmpty
	private String celular;
	@NotEmpty
	@Email
	private String correo;
	
	//Relación
	
		@OneToMany (fetch = FetchType.LAZY, mappedBy = "pasajero", cascade = CascadeType.ALL)
		List<Parada> paradas;
	
	
	
	
	public Integer getIdPasajero() {
		return idPasajero;
	}




	public void setIdPasajero(Integer idPasajero) {
		this.idPasajero = idPasajero;
	}




	public String getCedula() {
		return cedula;
	}




	public void setCedula(String cedula) {
		this.cedula = cedula;
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




	public String getTelefono() {
		return telefono;
	}




	public void setTelefono(String telefono) {
		this.telefono = telefono;
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




	@Override
	public String toString() {
		return "Pasajero [idPasajero=" + idPasajero + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido="
				+ apellido + ", telefono=" + telefono + ", celular=" + celular + ", correo=" + correo + "]";
	}
	
	

	
	
	
	
}
