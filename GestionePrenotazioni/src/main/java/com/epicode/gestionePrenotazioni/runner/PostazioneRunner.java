package com.epicode.gestionePrenotazioni.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.gestionePrenotazioni.enums.TipoPostazione;
import com.epicode.gestionePrenotazioni.model.Edificio;
import com.epicode.gestionePrenotazioni.model.Postazione;
import com.epicode.gestionePrenotazioni.service.EdificioService;
import com.epicode.gestionePrenotazioni.service.PostazioneService;

@Component
public class PostazioneRunner implements CommandLineRunner {
	
	private final PostazioneService postazioneService;
	private final EdificioService edificioService;
			
    @Autowired
    public PostazioneRunner(PostazioneService postazioneService, EdificioService edificioService) {
        this.postazioneService = postazioneService;
        this.edificioService = edificioService;
    }

    @Override
    public void run(String... args) {
    	Edificio edificioEsistente = edificioService.getEdificioById(1L);
    	
        Postazione postazione = new Postazione();
        postazione.setCodice("AB123CD");
        postazione.setDescrizione("Postazione Back-End");
        postazione.setTipo(TipoPostazione.PRIVATO);
        postazione.setNumeroMassimoOccupanti(2);
        postazione.setEdificio(edificioEsistente);

//        Postazione postazioneCreata = postazioneService.createPostazione(postazione);
//        System.out.println("Postazione con ID " + postazioneCreata.getId() + " creata");
        
        List<Postazione> findPostazioniDisponibili = postazioneService.findPostazioniDisponibili(TipoPostazione.PRIVATO, "Roma");
        if(findPostazioniDisponibili.size() > 0) {
        	System.out.println(findPostazioniDisponibili);
        }else {
        	System.out.println("Nessuna postazione trovata");
        }
    }

}
