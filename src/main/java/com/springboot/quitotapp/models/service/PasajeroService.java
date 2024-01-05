package com.springboot.quitotapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springboot.quitotapp.models.entity.Pasajero;
import com.springboot.quitotapp.models.repository.PasajeroRepository;
@Service
public class PasajeroService implements IPasajeroService {

	@Autowired
	private PasajeroRepository pasajeroRepository;
	
	@Override
	public List<Pasajero> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Pasajero>) pasajeroRepository.findAll();
	}

	@Override
	public void guardar(Pasajero pasajero) {
		// TODO Auto-generated method stub
		pasajeroRepository.save(pasajero);

	}

	@Override
	public Pasajero buscarPorId(Integer idPasajero) {
		// TODO Auto-generated method stub
		return pasajeroRepository.findById(idPasajero).orElse(null);
	}

	@Override
	public void borrar(Integer idPasajero) {
		// TODO Auto-generated method stub
		pasajeroRepository.deleteById(idPasajero);

	}

}
