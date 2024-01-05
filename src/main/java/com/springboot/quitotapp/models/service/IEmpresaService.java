package com.springboot.quitotapp.models.service;

import java.util.List;

import com.springboot.quitotapp.models.entity.Empresa;

public interface IEmpresaService {
	
	public List<Empresa> listarTodas();
	public void guardar(Empresa empresa);
	public Empresa buscarPorId(Integer idEmpresa);
	public void borrar(Integer idEmpresa);

}
