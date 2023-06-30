package com.epicode;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		
		ElementoMultimediale[] elementi = new ElementoMultimediale[5];
		
		elementi[0] = new Immagine("Immagine 1", 2);
		elementi[1] = new Immagine("Immagine 2", 6);
		elementi[2] = new Video("Video 1", 2, 5, 3);
		elementi[3] = new RegistrazioneAudio("Audio 1", 5, 3);
		elementi[4] = new RegistrazioneAudio("Audio 2", 1, 5);
		
		Scanner sc = new Scanner(System.in);
        int scelta;
        
        do {
            System.out.println("Seleziona l'elemento da eseguire (1-5) o 0 per uscire:");
            scelta = sc.nextInt();

            if(scelta >= 1 && scelta <= 5) {
                ElementoMultimediale elemento = elementi[scelta - 1];
                if(elemento instanceof Immagine) {
                	Immagine immagine = (Immagine) elemento;
                    immagine.show();
                }else if(elemento instanceof Video) {
                	Video video = (Video) elemento;
                    video.play();
                }else if(elemento instanceof RegistrazioneAudio) {
                	RegistrazioneAudio audio = (RegistrazioneAudio) elemento;
                	audio.play();
                }else {
                	System.out.println("Riproduzione non disponibile");
                }
            }else if (scelta != 0) {
                System.out.println("Scelta non valida. Riprova.");
            }
        } while (scelta != 0);

	}

}
