package com.springboot.quitotapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.quitotapp.models.entity.Parada;
import com.springboot.quitotapp.models.repository.ParadaRepository;

@Service
public class ParadaService implements IParadaService {

	@Autowired
	private ParadaRepository paradaRepository;
	
	@Override
	public List<Parada> listarTodas() {
		// TODO Auto-generated method stub
		return (List<Parada>) paradaRepository.findAll();
	}

	@Override
	public void guardar(Parada parada) {
		// TODO Auto-generated method stub
        paradaRepository.save(parada);
	}

	@Override
	public Parada buscarPorId(Integer idParada) {
		// TODO Auto-generated method stub
		return paradaRepository.findById(idParada).orElse(null);
	}

	@Override
	public void borrar(Integer idParada) {
		// TODO Auto-generated method stub
         paradaRepository.deleteById(idParada);
	}

}
