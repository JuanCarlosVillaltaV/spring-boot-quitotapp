package com.springboot.quitotapp.models.entity;

import java.io.Serializable;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "paradas")
public class Parada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer idParada;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String direccion;
	@NotEmpty
	private String ubicacion;
	@NotNull
	private String estadoRegistro;
	
	
	//Relación
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idPasajero")
	private Pasajero pasajero;


	//Relación tabla intermedia
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinTable
	(
			name="parada_ruta",joinColumns = @JoinColumn(name ="parada_idParada",referencedColumnName = "idParada"),
			           inverseJoinColumns  = @JoinColumn(name ="ruta_idRuta",referencedColumnName = "idRuta")
			)
	private List<Ruta> rutas;
	//Relación tabla intermedia fin


	public Integer getIdParada() {
		return idParada;
	}

	public void setIdParada(Integer idParada) {
		this.idParada = idParada;
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	@Override
	public String toString() {
		return "Parada [idParada=" + idParada + ", nombre=" + nombre + ", direccion=" + direccion + ", ubicacion="
				+ ubicacion + ", estadoRegistro=" + estadoRegistro + "]";
	}

}
