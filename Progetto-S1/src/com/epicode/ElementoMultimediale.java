package com.epicode;

public class ElementoMultimediale implements Riproducibile, Visualizzabile {
	
	protected String titolo;
	
	public ElementoMultimediale(String titolo) {
		this.titolo = titolo;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public abstract class Riproducibile extends ElementoMultimediale {
	    protected int durata;

	    public Riproducibile(String titolo, int durata) {
	        super(titolo);
	        this.durata = durata;
	    }

	    public abstract void play();
	}

	public void play() {}

	public void show() {}
	
}
