package com.springboot.quitotapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.quitotapp.models.entity.Ruta;
import com.springboot.quitotapp.models.repository.RutaRepository;

@Service
public class RutaService implements IRutaService {

	@Autowired
	
    private RutaRepository rutaRepository; 
	
	@Override
	public List<Ruta> listarTodas() {
		// TODO Auto-generated method stub
		return (List<Ruta>) rutaRepository.findAll();
	}

	@Override
	public void guardar(Ruta ruta) {
		// TODO Auto-generated method stub
		rutaRepository.save(ruta);
	}

	@Override
	public Ruta buscarPorId(Integer idRuta) {
		// TODO Auto-generated method stub
		return rutaRepository.findById(idRuta).orElse(null);
	}

	@Override
	public void borrar(Integer idRuta) {
		// TODO Auto-generated method stub
		rutaRepository.deleteById(idRuta);

	}

}
