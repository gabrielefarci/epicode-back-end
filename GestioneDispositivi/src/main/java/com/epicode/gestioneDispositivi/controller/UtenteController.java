package com.epicode.gestioneDispositivi.controller;

import java.net.URI;
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

import com.epicode.gestioneDispositivi.repository.IUtenteRepository;
import com.epicode.gestioneDispositivi.security.entity.User;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
	
	private final IUtenteRepository utenteRepository;

    public UtenteController(IUtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @GetMapping
    public Iterable<User> getAllUtenti() {
        return utenteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUtenteById(@PathVariable Long id) {
        Optional<User> utente = utenteRepository.findById(id);
        return utente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUtente(@RequestBody User utente) {
    	User newUtente = utenteRepository.save(utente);
        return ResponseEntity.created(URI.create("/utenti/" + newUtente.getId())).body(newUtente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUtente(@PathVariable Long id, @RequestBody User updatedUtente) {
        Optional<User> existingUtente = utenteRepository.findById(id);
        if (existingUtente.isPresent()) {
            updatedUtente.setId(id);
            User savedUtente = utenteRepository.save(updatedUtente);
            return ResponseEntity.ok(savedUtente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtente(@PathVariable Long id) {
        Optional<User> existingUtente = utenteRepository.findById(id);
        if (existingUtente.isPresent()) {
            utenteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
