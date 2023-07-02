package com.epicode;

public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile {
	private int volume;
	private int durata;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void alzaVolume() {
        volume++;
    }

    @Override
    public void play() {
    	System.out.print("Riproduzione della registrazione audio: ");
        for (int i = 0; i < durata; i++) {
        	System.out.print(titolo);
            for (int j = 0; j < volume; j++) {
                System.out.print("!");
            }
        }
        System.out.println();
    }
}
