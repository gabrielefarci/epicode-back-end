package com.epicode.gestioneDispositivi.model;

import com.epicode.gestioneDispositivi.enums.StatoDispositivo;
import com.epicode.gestioneDispositivi.security.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "dispositivi")
public class Dispositivo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String tipo;
	@Enumerated(EnumType.STRING)
    private StatoDispositivo stato;
	@ManyToOne
    private User utente;
	
}
