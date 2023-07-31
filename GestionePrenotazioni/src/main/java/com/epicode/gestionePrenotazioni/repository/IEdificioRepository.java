package com.epicode.gestionePrenotazioni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestionePrenotazioni.model.Edificio;

@Repository
public interface IEdificioRepository extends CrudRepository<Edificio, Long> {
	
	

}
