package com.epicode.project_s3;

import java.time.LocalDate;

public class Prestito {
	
	private int utente;
	private String elemento_prestato;
	private LocalDate data_inizio_prestito;
	private LocalDate data_restituzione_prevista;
	private LocalDate data_restituzione_effettiva;
	
	public Prestito(int utente, String elemento_prestato, LocalDate data_inizio_prestito,
			LocalDate data_restituzione_prevista, LocalDate data_restituzione_effettiva) {
		super();
		this.utente = utente;
		this.elemento_prestato = elemento_prestato;
		this.data_inizio_prestito = data_inizio_prestito;
		this.data_restituzione_prevista = data_restituzione_prevista;
		this.data_restituzione_effettiva = data_restituzione_effettiva;
	}

	public Prestito(String elemento_prestato, LocalDate data_inizio_prestito, LocalDate data_restituzione_prevista,
			LocalDate data_restituzione_effettiva) {
		super();
		this.elemento_prestato = elemento_prestato;
		this.data_inizio_prestito = data_inizio_prestito;
		this.data_restituzione_prevista = data_restituzione_prevista;
		this.data_restituzione_effettiva = data_restituzione_effettiva;
	}

	public Prestito(String elemento_prestato) {
		super();
		this.elemento_prestato = elemento_prestato;
	}

	public int getUtente() {
		return utente;
	}

	public void setUtente(int utente) {
		this.utente = utente;
	}

	public String getElemento_prestato() {
		return elemento_prestato;
	}

	public void setElemento_prestato(String elemento_prestato) {
		this.elemento_prestato = elemento_prestato;
	}

	public LocalDate getData_inizio_prestito() {
		return data_inizio_prestito;
	}

	public void setData_inizio_prestito(LocalDate data_inizio_prestito) {
		this.data_inizio_prestito = data_inizio_prestito;
	}

	public LocalDate getData_restituzione_prevista() {
		return data_restituzione_prevista;
	}

	public void setData_restituzione_prevista(LocalDate data_restituzione_prevista) {
		this.data_restituzione_prevista = data_restituzione_prevista;
	}

	public LocalDate getData_restituzione_effettiva() {
		return data_restituzione_effettiva;
	}

	public void setData_restituzione_effettiva(LocalDate data_restituzione_effettiva) {
		this.data_restituzione_effettiva = data_restituzione_effettiva;
	}

	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", elemento_prestato=" + elemento_prestato + ", data_inizio_prestito="
				+ data_inizio_prestito + ", data_restituzione_prevista=" + data_restituzione_prevista
				+ ", data_restituzione_effettiva=" + data_restituzione_effettiva + "]";
	}
	
}
