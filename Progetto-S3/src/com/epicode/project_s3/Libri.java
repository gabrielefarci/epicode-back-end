package com.epicode.project_s3;

public class Libri extends ElementiCatalogo {
    
	private String autore;
    private String genere;

    public Libri(String isbn, String titolo, int anno_pubblicazione, int numero_pagine, String autore, String genere) {
        super(isbn, titolo, anno_pubblicazione, numero_pagine);
        this.autore = autore;
        this.genere = genere;
    }
    
    
    public String getIsbn() {
    	return isbn;
    }
    
    public String getTitolo() {
    	return title;
    }
    
    public int getAnnoPubblicazione() {
    	return publicationYear;
    }
    
    public int getNumeroPagine() {
    	return pageCount;
    }

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}

	@Override
	public String toString() {
		return "Libro: [codice ISBN: " + isbn + ", titolo: " + title + ", anno di pubblicazione: " + publicationYear + ", numero di pagine: " + pageCount + ", autore: " + autore + ", genere: " + genere + "]";
	}
	
}
