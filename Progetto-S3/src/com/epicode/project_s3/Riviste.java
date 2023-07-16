package com.epicode.project_s3;

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
        return "Rivista: [" + "codice Isbn: " + getIsbn() + ", titolo: " + getTitle() + ", anno di pubblicazione: " + getPublicationYear() + ", numero di pagine: " + getPageCount() + ", periodicità: " + periodicity + "]";
    }
	
}
