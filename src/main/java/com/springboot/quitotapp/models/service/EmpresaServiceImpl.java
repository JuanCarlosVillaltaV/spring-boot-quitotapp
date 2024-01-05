package com.springboot.quitotapp.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.quitotapp.models.entity.Empresa;
import com.springboot.quitotapp.models.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public List<Empresa> listarTodas() {
		// TODO Auto-generated method stub
		return (List<Empresa>) empresaRepository.findAll();
	}

	@Override
	public void guardar(Empresa empresa) {
		// TODO Auto-generated method stub
		empresaRepository.save(empresa);

	}

	@Override
	public Empresa buscarPorId(Integer idEmpresa) {
		// TODO Auto-generated method stub
		return empresaRepository.findById(idEmpresa).orElse(null);
	}

	@Override
	public void borrar(Integer idEmpresa) {
		// TODO Auto-generated method stub
		empresaRepository.deleteById(idEmpresa);

	}

}
