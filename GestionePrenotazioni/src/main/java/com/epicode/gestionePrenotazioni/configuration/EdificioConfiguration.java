package com.epicode.gestionePrenotazioni.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.gestionePrenotazioni.model.Edificio;

@Configuration
public class EdificioConfiguration {
	
	@Bean("customEdificioBean")
	@Scope("prototype")
    public Edificio edificio() {
        Edificio edificio = new Edificio();
        return edificio;
    }

}
