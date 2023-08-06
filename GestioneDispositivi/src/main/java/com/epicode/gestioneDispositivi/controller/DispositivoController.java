package com.epicode.gestioneDispositivi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.gestioneDispositivi.enums.StatoDispositivo;
import com.epicode.gestioneDispositivi.model.Dispositivo;
import com.epicode.gestioneDispositivi.repository.IDispositivoRepository;
import com.epicode.gestioneDispositivi.repository.IUtenteRepository;
import com.epicode.gestioneDispositivi.security.entity.User;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {
	
	private final IDispositivoRepository dispositivoRepository;
	private final IUtenteRepository utenteRepository;

    public DispositivoController(IDispositivoRepository dispositivoRepository, IUtenteRepository utenteRepository) {
        this.dispositivoRepository = dispositivoRepository;
		this.utenteRepository = utenteRepository;
    }

    @GetMapping
    public Iterable<Dispositivo> getAllDispositivi() {
        return dispositivoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> getDispositivoById(@PathVariable Long id) {
        Optional<Dispositivo> dispositivo = dispositivoRepository.findById(id);
        return dispositivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dispositivo> createDispositivo(@RequestBody Dispositivo dispositivo) {
        Dispositivo newDispositivo = dispositivoRepository.save(dispositivo);
        return ResponseEntity.created(URI.create("/dispositivi/" + newDispositivo.getId())).body(newDispositivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> updateDispositivo(@PathVariable Long id, @RequestBody Dispositivo updatedDispositivo) {
        Optional<Dispositivo> existingDispositivo = dispositivoRepository.findById(id);
        if (existingDispositivo.isPresent()) {
            updatedDispositivo.setId(id);
            Dispositivo savedDispositivo = dispositivoRepository.save(updatedDispositivo);
            return ResponseEntity.ok(savedDispositivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id) {
        Optional<Dispositivo> existingDispositivo = dispositivoRepository.findById(id);
        if (existingDispositivo.isPresent()) {
            dispositivoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/disponibili")
    public List<Dispositivo> getDispositiviDisponibili() {
        return dispositivoRepository.findByStato();
    }
    
    @PostMapping("/{dispositivoId}/assegna/{utenteId}")
    public ResponseEntity<String> assegnaDispositivoAUtente(
            @PathVariable Long dispositivoId,
            @PathVariable Long utenteId
    ) {
        Optional<Dispositivo> dispositivoOptional = dispositivoRepository.findById(dispositivoId);
        Optional<User> utenteOptional = utenteRepository.findById(utenteId);
        
        Dispositivo dispositivo = dispositivoOptional.get();

        if(dispositivoOptional.isPresent() && utenteOptional.isPresent() && dispositivo.getStato() == StatoDispositivo.DISPONIBILE) {
            
            User utente = utenteOptional.get();

            dispositivo.setUtente(utente);
            dispositivo.setStato(StatoDispositivo.ASSEGNATO);
            dispositivoRepository.save(dispositivo);

            return ResponseEntity.ok("Dispositivo assegnato con successo.");
        }else {
        	return ResponseEntity.badRequest().body("Il dispositivo non è disponibile per l'assegnazione.");
        }
    }
    
}
