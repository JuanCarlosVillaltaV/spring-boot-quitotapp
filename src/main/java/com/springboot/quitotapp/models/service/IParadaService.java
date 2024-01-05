package com.springboot.quitotapp.models.service;

import java.util.List;

import com.springboot.quitotapp.models.entity.Parada;

public interface IParadaService {
	

	public List<Parada> listarTodas();

	public void guardar(Parada parada);

	public Parada buscarPorId(Integer idParada);

	public void borrar(Integer idParada);
	
}
