package com.epicode;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		
		ElementoMultimediale[] elementi = new ElementoMultimediale[5];
		
		Scanner sc = new Scanner(System.in);
        int scelta;
        
        for(int i = 0; i < 5; i++) {
        	if(i > 0) {
        		System.out.println("-------------------------");
        	}
        	System.out.println("Crea 5 elementi: \n" + "Inserisci 1 per creare un immagine. \n" + "Inserisci 2 per creare un video. \n" + "Inserisci 3 per creare una registeazione audio.");
        	scelta = sc.nextInt();
        	
        	if(scelta == 1) {
        		System.out.print("Inserisci il titolo dell'immagine: ");
        		String titolo = sc.next();
        		
            	System.out.print("Inserisci la luminosità dell'immagine: ");
            	int luminosita = sc.nextInt();
            	
            	elementi[i] = new Immagine(titolo, luminosita);
            	System.out.println("Hai creato un immagine! \n");
            }else if(scelta == 2) {
            	System.out.print("Inserisci il titolo del video: ");
        		String titolo = sc.next();
        		
            	System.out.print("Inserisci la durata del video: ");
            	int durata = sc.nextInt();
            	
            	System.out.print("Inserisci il volume del video: ");
            	int volume = sc.nextInt();
            	
            	System.out.print("Inserisci la luminosità del video: ");
            	int luminosita = sc.nextInt();
            	
            	elementi[i] = new Video(titolo, durata, volume, luminosita);	
            	System.out.println("Hai creato un video! \n");
            }else if(scelta == 3) {
            	System.out.print("Inserisci il titolo della registrazione audio: ");
        		String titolo = sc.next();
        		
            	System.out.print("Inserisci la durata della registrazione audio: ");
            	int durata = sc.nextInt();
            	
            	System.out.print("Inserisci il volume della registrazione audio: ");
            	int volume = sc.nextInt();
            	
            	elementi[i] = new RegistrazioneAudio(titolo, durata, volume);
            	System.out.println("Hai creato una registrazione audio! \n");
            }
        }
        
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
