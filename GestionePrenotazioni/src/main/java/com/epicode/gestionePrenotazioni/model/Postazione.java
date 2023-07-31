package com.epicode.gestionePrenotazioni.model;

import com.epicode.gestionePrenotazioni.enums.TipoPostazione;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Postazione {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codice;

    @Column(nullable = false)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPostazione tipo;

    @Column(name = "numero_massimo_occupanti", nullable = false)
    private int numeroMassimoOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;

}
