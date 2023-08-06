package com.epicode.gestioneDispositivi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestioneDispositivi.model.Dispositivo;
import com.epicode.gestioneDispositivi.repository.IDispositivoRepository;

@Service
public class DispositivoService {
	
	private final IDispositivoRepository dispositivoRepository;

    @Autowired
    public DispositivoService(IDispositivoRepository dispositivoRepository) {
        this.dispositivoRepository = dispositivoRepository;
    }

    public List<Dispositivo> getAllDispositivi() {
        return (List<Dispositivo>) dispositivoRepository.findAll();
    }

}
