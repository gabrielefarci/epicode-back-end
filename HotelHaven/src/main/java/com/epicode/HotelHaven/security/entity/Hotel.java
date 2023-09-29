package com.epicode.HotelHaven.security.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomeStruttura;
    @Column(length = 1000)
    private String descrizione;
    @ElementCollection
    @CollectionTable(name = "foto_hotel")
    private List<String> fotoEImmagineStruttura;
    @Embedded
    private Indirizzo indirizzoFisico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private List<Camera> camereDisponibili;
	
}
