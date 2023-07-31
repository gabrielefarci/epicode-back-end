package com.epicode.gestionePrenotazioni.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.gestionePrenotazioni.model.Postazione;
import com.epicode.gestionePrenotazioni.model.Prenotazione;
import com.epicode.gestionePrenotazioni.model.Utente;
import com.epicode.gestionePrenotazioni.service.PostazioneService;
import com.epicode.gestionePrenotazioni.service.PrenotazioneService;
import com.epicode.gestionePrenotazioni.service.UtenteService;

@Component
public class PrenotazioneRunner implements CommandLineRunner {
	
	private final PrenotazioneService prenotazioneService;
	private final PostazioneService postazioneService;
	private final UtenteService utenteService;

    @Autowired
    public PrenotazioneRunner(PrenotazioneService prenotazioneService, PostazioneService postazioneService, UtenteService utenteService) {
        this.prenotazioneService = prenotazioneService;
        this.postazioneService = postazioneService;
        this.utenteService = utenteService;
    }

    @Override
    public void run(String... args) {
    	Postazione postazioneEsistente = postazioneService.getPostazioneById(1L);
    	Utente utenteEsistente = utenteService.getUtenteById(1L);
    	
        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setPostazione(postazioneEsistente);
        prenotazione1.setUtente(utenteEsistente);
        prenotazione1.setData(LocalDate.of(2023, 8, 2));

      Prenotazione prenotazioneCreata = prenotazioneService.createPrenotazione(prenotazione1);
      System.out.println("Prenotazione con ID " + prenotazioneCreata.getId() + " creata");
    }

}
