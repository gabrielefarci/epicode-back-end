package com.epicode.project_s3;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		int scelta;
		
		Random random = new Random();
		
		DbConnection database = new DbConnection();
		
		try {
			DbConnection db = new DbConnection();
			Utente u = new Utente("Mario", "Rossi", LocalDate.of(2000, 11, 7));
			Utente u2 = new Utente("Francesca", "Neri", LocalDate.of(1998, 4, 21));
			//db.inserisciUtente();
			//db.cancellaUtente();
			Prestito p = new Prestito(1, "Twilight", LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 30), LocalDate.of(2023, 6, 27));
			database.inserisciElementoInPrestito(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		do {
			System.out.println("Inserisci 1 per creare un libro.");
			System.out.println("Inserisci 2 per creare una rivista.");
			System.out.println("Inserisci 3 per rimuovere un elemento attraverso il codice ISBN.");
			System.out.println("Inserisci 4 per cercare un elemento attraverso il codice ISBN.");
			System.out.println("Inserisci 5 per cercare un elemento attraverso l'anno di pubblicazione.");
			System.out.println("Inserisci 6 per cercare un elemento attraverso il nome dell'autore.");
			System.out.println("Inserisci 7 per cercare un elemento attraverso il nome del libro.");
			System.out.println("Inserisci 8 per cercare gli elementi attualmente in prestito attraverso un numero tessera.");
			System.out.println("Inserisci 9 per cercare tutti i prestiti scaduti e non ancora restituiti.");
			System.out.println("Inserisci 0 per far terminare il programma.");
			
			scelta = sc.nextInt();
			sc.nextLine();
			
			if(scelta == 1) {
				
				System.out.print("\nInserisci il titolo del libro: ");
				String titolo = sc.nextLine();
				
				System.out.print("Inserisci l'anno di pubblicazione: ");
				int annoPubblicazione = sc.nextInt();
				sc.nextLine();
			
				System.out.print("Inserisci il numero di pagine: ");
				int numeroPagine = sc.nextInt();
				sc.nextLine();
			
				System.out.print("Inserisci il nome dell'autore: ");
				String nomeAutore = sc.nextLine();
			
				System.out.print("Inserisci il genere: ");
				String genere = sc.nextLine();
				
				String libriIsbn = generateIsbn(random);
				Libri l = new Libri(libriIsbn, titolo, annoPubblicazione, numeroPagine, nomeAutore, genere);
				
				try {
					database.inserisciLibro(l, l);
				}catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
			}else if(scelta == 2) {
				
				System.out.print("\nInserisci il titolo della rivista: ");
				String titolo = sc.nextLine();
			
				System.out.print("Inserisci l'anno di pubblicazione: ");
				int annoPubblicazione = sc.nextInt();
				sc.nextLine();
			
				System.out.print("Inserisci il numero di pagine: ");
				int numeroPagine = sc.nextInt();
				sc.nextLine();
				
				String rivisteIsbn = generateIsbn(random);
				Riviste r = new Riviste(rivisteIsbn, titolo, annoPubblicazione, numeroPagine, Periodicity.SETTIMANALE);
				
				try {
					database.inserisciRivista(r, r);
				}catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
			}else if (scelta == 3) {
				
				//Rimozione di un elemento attraverso un codice ISBN
				System.out.print("\nInserisci il codice ISBN dell'elemento che vuoi eliminare: ");
				int codiceIsbn = sc.nextInt();
				
				try {
			        database.cancellaElemento(codiceIsbn);
			    }catch (SQLException e) {
			    	System.out.println(e.getMessage());
			    }
				
				System.out.println("Elemento rimosso con successo.\n");
				
			}else if (scelta == 4) {
				
				System.out.print("\nInserisci il codice ISBN dell'elemento che vuoi cercare: ");
				String codiceIsbn = sc.next();
				
				try {
			        database.ricercaElementoIsbn(codiceIsbn);
			    }catch (SQLException e) {
			    	System.out.println(e.getMessage());
			    }
				
			}else if (scelta == 5) {
				
				System.out.print("\nInserisci l'anno di pubblicazione dell'elemento che vuoi cercare: ");
				int annoPubblicazione = sc.nextInt();
				
				try {
			        database.ricercaElementoAnnoPubblicazione(annoPubblicazione);
			    }catch (SQLException e) {
			    	System.out.println(e.getMessage());
			    }
				
			}else if (scelta == 6) {
				
				System.out.print("\nInserisci il nome dell'autore per cercare tutti i suoi elementi: ");
				String autore = sc.nextLine();
				
				try {
			        database.ricercaLibroAutore(autore);
			    }catch (SQLException e) {
			    	e.printStackTrace();
			    }
				
			}else if (scelta == 7) {
				
				System.out.print("\nInserisci il nome del libro che vuoi cercare: ");
				String titolo = sc.nextLine();
				
				try {
			        database.ricercaElementoTitolo(titolo);
			    }catch (SQLException e) {
			    	e.printStackTrace();
			    }
				
			}else if(scelta == 8) {
				
				System.out.print("\nInserisci il numero di tessera per cercare gli elementi in prestito: ");
				int numeroTessera = sc.nextInt();
				
				try {
			        database.ricercaElementiInPrestito(numeroTessera);
			    }catch (SQLException e) {
			    	System.out.println(e.getMessage());
			    }
				
			}
			
		}while (scelta != 0);

	}
	
	private static String generateIsbn(Random random) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }

}
