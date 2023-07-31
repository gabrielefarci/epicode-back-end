package com.epicode.gestionePrenotazioni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestionePrenotazioni.model.Utente;
import com.epicode.gestionePrenotazioni.repository.IUtenteRepository;

@Service
public class UtenteService {
	
	private final IUtenteRepository utenteRepository;

    @Autowired
    public UtenteService(IUtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public Utente createUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public void deleteUtente(Long id) {
        utenteRepository.deleteById(id);
    }
    
    public Utente getUtenteById(Long id) {
		return utenteRepository.findById(id).orElse(null);
	}

}
