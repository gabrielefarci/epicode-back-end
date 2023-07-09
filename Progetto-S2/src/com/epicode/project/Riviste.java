package com.epicode.project;

public class Riviste extends ElementiCatalogo {
	private Periodicity periodicity;

    public Riviste(String isbn, String title, int publicationYear, int pageCount, Periodicity periodicity) {
        super(isbn, title, publicationYear, pageCount);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }
    
    @Override
    public String toString() {
        return "Rivista: [" + "Isbn: " + getIsbn() + ", Titolo: " + getTitle() + ", Anno di pubblicazione: " + getPublicationYear() + ", Numero di pagine: " + getPageCount() + ", Periodicità: " + periodicity + "]\n";
    }
}
