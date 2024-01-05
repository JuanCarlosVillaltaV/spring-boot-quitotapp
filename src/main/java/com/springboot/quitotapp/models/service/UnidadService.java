package com.springboot.quitotapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.quitotapp.models.entity.Unidad;
import com.springboot.quitotapp.models.repository.UnidadRepository;

@Service
public class UnidadService implements IUnidadService {

	@Autowired
	private UnidadRepository unidadRepository;
	
	@Override
	public List<Unidad> listarTodas() {
		// TODO Auto-generated method stub
		return (List<Unidad>) unidadRepository.findAll();
	}

	@Override
	public void guardar(Unidad unidad) {
		unidadRepository.save(unidad);

	}

	@Override
	public Unidad buscarPorId(Integer idUnidad) {
		// TODO Auto-generated method stub
		return unidadRepository.findById(idUnidad).orElse(null);
	}

	@Override
	public void borrar(Integer idUnidad) {
		// TODO Auto-generated method stub
		unidadRepository.deleteById(idUnidad);

	}

}
