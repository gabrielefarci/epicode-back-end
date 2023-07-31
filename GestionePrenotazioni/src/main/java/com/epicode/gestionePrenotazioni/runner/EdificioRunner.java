package com.epicode.gestionePrenotazioni.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.gestionePrenotazioni.model.Edificio;
import com.epicode.gestionePrenotazioni.service.EdificioService;

@Component
public class EdificioRunner implements CommandLineRunner {
	
	private final EdificioService edificioService;

    @Autowired
    public EdificioRunner(EdificioService edificioService) {
        this.edificioService = edificioService;
    }

    @Override
    public void run(String... args) {
        Edificio edificio1 = new Edificio();
        edificio1.setNome("Epicode");
        edificio1.setIndirizzo("Via Roma");
        edificio1.setCitta("Roma");

//        Edificio edificioCreato = edificioService.createEdificio(edificio1);
//        System.out.println("Edificio con ID " + edificioCreato.getId() + " creato");
    }

}
