package com.springboot.quitotapp.models.service;

import java.util.List;

import com.springboot.quitotapp.models.entity.Ruta;

public interface IRutaService {

	public List<Ruta> listarTodas();
	public void guardar(Ruta ruta);
	public Ruta buscarPorId(Integer idRuta);
	public void borrar (Integer idRuta);
}
