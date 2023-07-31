package com.epicode.gestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestionePrenotazioni.enums.TipoPostazione;
import com.epicode.gestionePrenotazioni.model.Postazione;
import com.epicode.gestionePrenotazioni.repository.IPostazioneRepository;

@Service
public class PostazioneService {
	
	private final IPostazioneRepository postazioneRepository;

    @Autowired
    public PostazioneService(IPostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public Postazione createPostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public void deletePostazione(Long id) {
    	postazioneRepository.deleteById(id);
    }
    
    public Postazione getPostazioneById(Long id) {
		return postazioneRepository.findById(id).orElse(null);
	}
    
    public List<Postazione> findPostazioniDisponibili(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }

}
