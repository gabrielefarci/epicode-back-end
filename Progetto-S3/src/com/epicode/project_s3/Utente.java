package com.epicode.project_s3;

import java.time.LocalDate;

public class Utente {
	
	private String nome;
	private String cognome;
	private LocalDate data_nascita;
	private String numero_tessera;
	
	public Utente(String nome, String cognome, LocalDate data_nascita, String numero_tessera) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.numero_tessera = numero_tessera;
	}

	public Utente(String nome, String cognome, LocalDate data_nascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(LocalDate data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getNumero_tessera() {
		return numero_tessera;
	}

	public void setNumero_tessera(String numero_tessera) {
		this.numero_tessera = numero_tessera;
	}

	@Override
	public String toString() {
		return "Utente [nome: " + nome + ", cognome: " + cognome + ", data_nascita: " + data_nascita + ", numero_tessera: " + numero_tessera + "]";
	}
	
}
