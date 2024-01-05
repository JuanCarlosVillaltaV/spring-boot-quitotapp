package com.springboot.quitotapp.models.service;

import java.util.List;

import com.springboot.quitotapp.models.entity.Chofer;

public interface IChoferService {
	
	public List<Chofer> listarTodos();
	public void guardar(Chofer chofer);
	public Chofer buscarPorId(Integer idChofer);
	public void borrar(Integer idChofer);

}
