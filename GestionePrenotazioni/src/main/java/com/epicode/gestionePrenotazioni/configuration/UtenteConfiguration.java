package com.epicode.gestionePrenotazioni.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.gestionePrenotazioni.model.Utente;

@Configuration
public class UtenteConfiguration {

	@Bean("customUtenteBean")
	@Scope("prototype")
	public Utente utente() {
		Utente utente = new Utente();
        return utente;
	}
	
}
