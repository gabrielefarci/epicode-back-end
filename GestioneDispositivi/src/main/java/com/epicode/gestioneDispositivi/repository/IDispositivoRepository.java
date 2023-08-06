package com.epicode.gestioneDispositivi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestioneDispositivi.model.Dispositivo;

@Repository
public interface IDispositivoRepository extends CrudRepository<Dispositivo, Long> {
	
	@Query("SELECT d FROM Dispositivo d WHERE d.stato = 'disponibile'")
    List<Dispositivo> findByStato();

}
