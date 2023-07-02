package com.epicode;

public class Video extends ElementoMultimediale implements Riproducibile {

	private int durata;
	private int volume;
	private int luminosita;

	public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

	public void abbassaVolume() {
        if(volume > 0) {
            volume--;
        }
    }

    public void alzaVolume() {
        volume++;
    }
    
    public void aumentaLuminosita() {
    	luminosita++;
    }
    
    public void diminuisciLuminosita() {
    	if(luminosita > 0) {
    		luminosita--;
    	}
    }

    @Override
    public void play() {
    	System.out.print("Riproduzione del video: ");
        for(int i = 0; i < durata; i++) {
        	System.out.print(titolo);
            for(int j = 0; j < volume; j++) {
                System.out.print("!");
            }
            for(int y = 0; y < luminosita; y++) {
                System.out.print("*");
            }
        }
        System.out.println();
    }
	
}
