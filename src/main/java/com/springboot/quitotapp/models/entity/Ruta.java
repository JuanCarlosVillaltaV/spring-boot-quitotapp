package com.springboot.quitotapp.models.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="rutas")
public class Ruta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer idRuta;
	@NotEmpty
	private String descripcion;
	
	private Date fecha;
	
	@NotEmpty
	private String origen;
	@NotEmpty
	private String arribo;
	@NotEmpty
	private String ubicacion;
	@NotNull
	private Integer estadoRegistro;
	
	
//Relación
    
    //@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	//@JoinColumn(name ="fkEmpresa")
    
	//private Ruta fkRuta;
    @ManyToOne
    private Empresa empresa;
    
    //Relación tabla intermedia
    @ManyToMany(mappedBy = "rutas")
    private List<Parada> paradas;
    //Relación tabla intermedia fin
	

	public Integer getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getArribo() {
		return arribo;
	}
	public void setArribo(String arribo) {
		this.arribo = arribo;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	@Override
	public String toString() {
		return "Ruta [idRuta=" + idRuta + ", descripcion=" + descripcion + ", fecha=" + fecha + ", origen=" + origen
				+ ", arribo=" + arribo + ", ubicacion=" + ubicacion + ", estadoRegistro=" + estadoRegistro + "]";
	}
	
	
	
}
