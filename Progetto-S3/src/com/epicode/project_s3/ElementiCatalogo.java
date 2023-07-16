package com.epicode.project_s3;

enum Periodicity {
    SETTIMANALE,
    MENSILE,
    SEMESTRALE
}

public class ElementiCatalogo {
	
	protected String isbn;
    protected String title;
    protected int publicationYear;
    protected int pageCount;

    public ElementiCatalogo(String isbn, String title, int publicationYear, int pageCount) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pageCount = pageCount;
    }

	public ElementiCatalogo(String title) {
		super();
		this.title = title;
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
