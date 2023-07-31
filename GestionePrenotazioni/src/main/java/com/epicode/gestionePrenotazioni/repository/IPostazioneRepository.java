package com.epicode.gestionePrenotazioni.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestionePrenotazioni.enums.TipoPostazione;
import com.epicode.gestionePrenotazioni.model.Postazione;

@Repository
public interface IPostazioneRepository extends CrudRepository<Postazione, Long> {
	
	 List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);

}
