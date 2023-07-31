package com.epicode.gestionePrenotazioni.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.gestionePrenotazioni.model.Utente;
import com.epicode.gestionePrenotazioni.service.UtenteService;

@Component
public class UtenteRunner implements CommandLineRunner {
	
	private final UtenteService utenteService;

    @Autowired
    public UtenteRunner(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @Override
    public void run(String... args) {
        Utente utente = new Utente();
        utente.setUsername("giuseppe.verdi");
        utente.setNomeCompleto("Giuseppe Verdi");
        utente.setEmail("g.verdi@example.com");

//        Utente utenteCreato = utenteService.createUtente(utente);
//        System.out.println("Utente con ID " + utenteCreato.getId() + " creato");
    }

}
