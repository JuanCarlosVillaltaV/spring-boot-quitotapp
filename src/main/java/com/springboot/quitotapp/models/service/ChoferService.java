package com.springboot.quitotapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.quitotapp.models.entity.Chofer;
import com.springboot.quitotapp.models.repository.ChoferRepository;

@Service
public class ChoferService implements IChoferService {

	@Autowired
	private ChoferRepository choferRepository;
	
	@Override
	public List<Chofer> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Chofer>) choferRepository.findAll();
	}

	@Override
	public void guardar(Chofer chofer) {
		// TODO Auto-generated method stub
         choferRepository.save(chofer);
	}

	@Override
	public Chofer buscarPorId(Integer idChofer) {
		// TODO Auto-generated method stub
		return choferRepository.findById(idChofer).orElse(null);
	}

	@Override
	public void borrar(Integer idChofer) {
		// TODO Auto-generated method stub
         choferRepository.deleteById(idChofer);
	}

}
