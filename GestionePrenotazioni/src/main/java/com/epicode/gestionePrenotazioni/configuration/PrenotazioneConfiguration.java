package com.epicode.gestionePrenotazioni.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.gestionePrenotazioni.model.Prenotazione;

@Configuration
public class PrenotazioneConfiguration {
	
	@Bean("customPrenotazioneBean")
	@Scope("prototype")
	public Prenotazione prenotazione() {
		Prenotazione prenotazione = new Prenotazione();
        return prenotazione;
	}

}
