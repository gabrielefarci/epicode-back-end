package com.epicode.gestionePrenotazioni.repository;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestionePrenotazioni.model.Postazione;
import com.epicode.gestionePrenotazioni.model.Prenotazione;

@Repository
public interface IPrenotazioneRepository extends CrudRepository<Prenotazione, Long> {
	
	boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);

}
