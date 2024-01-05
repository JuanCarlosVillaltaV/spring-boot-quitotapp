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
@Table(name="unidades")
public class Unidad implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Integer idUnidad;
	@NotEmpty
	private String matricula;
	@NotEmpty
	private String ticket;
	@NotNull
	private Integer estadoRegistro;
	
	//Relación
		@ManyToOne
		private Empresa empresa;
		
		//Relación tabla intermedia
		@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
		@JoinTable(
				name="unidad_chofer",joinColumns = @JoinColumn(name="unidad_idUnidad",referencedColumnName = "idUnidad"),
				              inverseJoinColumns = @JoinColumn(name="chofer_idChofer",referencedColumnName = "idChofer")
				)
		private List<Chofer> choferes;
		//Relación tabla intermedia fin 
	
	
	public Integer getIdUnidad() {
		return idUnidad;
	}
	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	@Override
	public String toString() {
		return "Unidad [idUnidad=" + idUnidad + ", matricula=" + matricula + ", ticket=" + ticket + ", estadoRegistro="
				+ estadoRegistro + "]";
	}

	
}
