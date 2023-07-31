package com.epicode.gestionePrenotazioni.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.gestionePrenotazioni.model.Postazione;

@Configuration
public class PostazioneConfiguration {
	
	@Bean("customPostazioneBean")
	@Scope("prototype")
	public Postazione postazione() {
		Postazione postazione = new Postazione();
        return postazione;
	}

}
