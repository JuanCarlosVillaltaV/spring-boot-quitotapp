package com.springboot.quitotapp.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.quitotapp.models.entity.Unidad;

@Repository
public interface UnidadRepository extends CrudRepository<Unidad, Integer> {

}
