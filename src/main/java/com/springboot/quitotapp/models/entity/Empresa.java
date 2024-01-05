package com.springboot.quitotapp.models.entity;

import java.io.Serializable;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;



@Entity
@Table(name="empresas")
public class Empresa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Integer idEmpresa;
	@NotEmpty
	
	private String ruc;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String direccion;
	@NotEmpty
	
	private String telefono;
	@NotEmpty
	@Email
	private String correo;
	
	
	//Relación
	
	
		//@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "fkEmpresa")
		  //private List<Ruta>listaRuta = new ArrayList<>();
		
		//@JoinColumn(name = "idEmpresa")
		//private Empresa empresas;
		@OneToMany(mappedBy = "empresa")
		List<Ruta> rutas;
		@OneToMany(mappedBy = "empresa")
		List<Unidad> unidades;
	
	
	
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "Empresa [idEmpresa=" + idEmpresa + ", ruc=" + ruc + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", correo=" + correo + "]";
	}
	
	
	

}
