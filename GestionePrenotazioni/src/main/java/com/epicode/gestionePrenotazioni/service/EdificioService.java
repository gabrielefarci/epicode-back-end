package com.epicode.gestionePrenotazioni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestionePrenotazioni.model.Edificio;
import com.epicode.gestionePrenotazioni.repository.IEdificioRepository;

@Service
public class EdificioService {
	
	private final IEdificioRepository edificioRepository;

    @Autowired
    public EdificioService(IEdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public Edificio createEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public void deleteEdificio(Long id) {
    	edificioRepository.deleteById(id);
    }

	public Edificio getEdificioById(Long id) {
		return edificioRepository.findById(id).orElse(null);
	}

}
