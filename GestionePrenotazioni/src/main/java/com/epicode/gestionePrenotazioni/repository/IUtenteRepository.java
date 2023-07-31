package com.epicode.gestionePrenotazioni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestionePrenotazioni.model.Utente;

@Repository
public interface IUtenteRepository extends CrudRepository<Utente, Long> {

	
	
}
