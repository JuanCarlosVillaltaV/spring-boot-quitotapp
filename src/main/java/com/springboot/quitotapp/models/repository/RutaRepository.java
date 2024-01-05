package com.springboot.quitotapp.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.quitotapp.models.entity.Ruta;

@Repository
public interface RutaRepository extends CrudRepository<Ruta, Integer> {

}
