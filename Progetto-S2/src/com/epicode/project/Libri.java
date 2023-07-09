package com.epicode.project;

public class Libri extends ElementiCatalogo {
	
	private String author;
    private String genere;

    public Libri(String isbn, String title, int publicationYear, int pageCount, String author, String genere) {
        super(isbn, title, publicationYear, pageCount);
        this.author = author;
        this.genere = genere;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenere() {
        return genere;
    }
    
    public String toString() {
        return "Libro: [" + "Isbn: " + getIsbn() + ", Titolo: " + getTitle() +  ", Anno di pubblicazione: " + getPublicationYear() + ", Numero di pagine: " + getPageCount() + ", Autore: " + author + ", Genere: " + genere + "]" + "\n";
    }
    
}
