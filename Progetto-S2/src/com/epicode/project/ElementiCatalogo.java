package com.epicode.project;

enum Periodicity {
    SETTIMANALE,
    MENSILE,
    SEMESTRALE
}

abstract class ElementiCatalogo {
	private String isbn;
    protected String title;
    protected int publicationYear;
    private int pageCount;

    public ElementiCatalogo(String isbn, String title, int publicationYear, int pageCount) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPageCount() {
        return pageCount;
    }
}
