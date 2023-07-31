package com.epicode.gestionePrenotazioni.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestionePrenotazioni.model.Postazione;
import com.epicode.gestionePrenotazioni.model.Prenotazione;
import com.epicode.gestionePrenotazioni.repository.IPrenotazioneRepository;

@Service
public class PrenotazioneService {
	
	private final IPrenotazioneRepository prenotazioneRepository;

    @Autowired
    public PrenotazioneService(IPrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public Prenotazione createPrenotazione(Prenotazione prenotazione) {
        if (isPostazioneAvailable(prenotazione.getPostazione(), prenotazione.getData())) {
            return prenotazioneRepository.save(prenotazione);
        }
        throw new IllegalArgumentException("Postazione non disponibile.");
    }

    public void deletePrenotazione(Long id) {
    	prenotazioneRepository.deleteById(id);
    }

	public Prenotazione getPrenotazioneById(Long id) {
		return prenotazioneRepository.findById(id).orElse(null);
	}
	
	private boolean isPostazioneAvailable(Postazione postazione, LocalDate data) {
        return !prenotazioneRepository.existsByPostazioneAndData(postazione, data);
    }

}
