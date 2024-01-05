package com.springboot.quitotapp.models.service;

import java.util.List;

import com.springboot.quitotapp.models.entity.Unidad;

public interface IUnidadService {

	public List<Unidad> listarTodas();
	public void guardar (Unidad unidad);
	public Unidad buscarPorId(Integer idUnidad);
	public void borrar(Integer idUnidad);
}
