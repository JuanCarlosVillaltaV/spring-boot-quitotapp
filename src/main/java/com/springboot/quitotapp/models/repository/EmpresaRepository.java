package com.springboot.quitotapp.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.quitotapp.models.entity.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

}
