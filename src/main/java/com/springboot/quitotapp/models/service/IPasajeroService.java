package com.springboot.quitotapp.models.service;

import java.util.List;

import com.springboot.quitotapp.models.entity.Pasajero;

public interface IPasajeroService {

	public List<Pasajero> listarTodos();

	public void guardar(Pasajero pasajero);

	public Pasajero buscarPorId(Integer idPasajero);

	public void borrar(Integer idPasajero);

}
