package com.epicode.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class MainProject {
	
	private static File file = new File("test.txt");

	public static void main(String[] args) {
		
		Catalogo catalogo = new Catalogo();
		
		Scanner sc = new Scanner(System.in);
		int scelta;
		
		Random random = new Random();
		
		do {
		
			System.out.println("Inserisci 1 per creare un libro.");
			System.out.println("Inserisci 2 per creare una rivista.");
			System.out.println("Inserisci 3 per rimuovere un elemento attraverso il codice ISBN.");
			System.out.println("Inserisci 4 per cercare un elemento attraverso l'anno di pubblicazione.");
			System.out.println("Inserisci 5 per cercare un elemento attraverso il nome dell'autore.");
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
				int numPagine = sc.nextInt();
				sc.nextLine();
			
				System.out.print("Inserisci il nome dell'autore: ");
				String nomeAutore = sc.nextLine();
			
				System.out.print("Inserisci il genere: ");
				String genere = sc.nextLine();
	
				String libriIsbn = generateIsbn(random);
				Libri book = new Libri(libriIsbn, titolo, annoPubblicazione, numPagine, nomeAutore, genere);
				catalogo.addItem(book);
				
				System.out.println("\nHai creato un libro.");
				
				try {
					scriviSuFile(catalogo, book.toString(), "test.txt");
					System.out.println("\n" + leggiDaFile(catalogo));
				} catch (IOException e) {
					System.out.println("Si è verificato un errore durante la scrittura del libro su file: " + e.getMessage());
				}
				
				System.out.println();
	
			}else if(scelta == 2) {
			
				System.out.print("\nInserisci il titolo della rivista: ");
				String titolo = sc.nextLine();
			
				System.out.print("Inserisci l'anno di pubblicazione: ");
				int annoPubblicazione = sc.nextInt();
				sc.nextLine();
			
				System.out.print("Inserisci il numero di pagine: ");
				int numPagine = sc.nextInt();
				sc.nextLine();
			
				String rivisteIsbn = generateIsbn(random);
				Riviste magazine = new Riviste(rivisteIsbn, titolo, annoPubblicazione, numPagine, Periodicity.MENSILE);
				catalogo.addItem(magazine);
				
				System.out.println("\nHai creato una rivista.");
			
				try {
		            scriviSuFile(catalogo, magazine.toString(), "test.txt");
		            System.out.println("\n" + leggiDaFile(catalogo));
		        } catch (IOException e) {
		            System.out.println("Si è verificato un errore durante la scrittura della rivista su file: " + e.getMessage());
		        }
			
				System.out.println();
			
			}else if(scelta == 3) {
			
				// Rimozione di un elemento dato un codice ISBN
				System.out.print("\nInserisci il codice ISBN dell'elemento che vuoi eliminare: ");
				String codiceIsbn = sc.next();
				boolean removed = catalogo.removeItem(codiceIsbn);
				if(removed) {
					System.out.println("\nElemento rimosso con successo.");
					try {
			            scriviSuFile(catalogo, catalogo.toString(), "test.txt");
			            System.out.println("\n" + leggiDaFile(catalogo));
			        } catch (IOException e) {
			            System.out.println("Si è verificato un errore durante la scrittura della rivista su file: " + e.getMessage());
			        }
				
					System.out.println();
				}else {
					System.out.println("Elemento non presente nel catalogo.\n");
				}
			
			}else if(scelta == 4) {
		
				// Ricerca per anno di pubblicazione
				System.out.print("\nInserisci l'anno di pubblicazione dell'elemento: ");
				int annoPubblicazione = sc.nextInt();
				List<ElementiCatalogo> itemsByYear = catalogo.searchByPublicationYear(annoPubblicazione);
				if (!itemsByYear.isEmpty()) {
					System.out.print("Elementi trovati nel catalogo: ");
					if (itemsByYear.size() > 1) {
					    int lastIndex = itemsByYear.size() - 1;
					    for (int i = 0; i < itemsByYear.size(); i++) {
					        ElementiCatalogo item = itemsByYear.get(i);
					        System.out.print(item.getTitle());
					        if (i != lastIndex) {
					            System.out.print(", ");
					        }else {
					        	System.out.println("\n");
					        }
					    }
					} else {
					    for (ElementiCatalogo item : itemsByYear) {
					        System.out.println(item.getTitle() + "\n");
					    }
					}
				}else {
				    System.out.println("Nessun elemento trovato nel catalogo. \n");
				}
			
		
			}else if(scelta == 5) {
		
				// Ricerca per autore
				System.out.print("\nInserisci il nome dell'autore: ");
				String nomeAutore = sc.nextLine();
				List<ElementiCatalogo> itemsByAuthor = catalogo.searchByAuthor(nomeAutore);
				System.out.print("Elementi di " + nomeAutore + ": ");
				if (itemsByAuthor.size() > 1) {
				    int lastIndex = itemsByAuthor.size() - 1;
				    for (int i = 0; i < itemsByAuthor.size(); i++) {
				        ElementiCatalogo item = itemsByAuthor.get(i);
				        System.out.print(item.getTitle());
				        if (i != lastIndex) {
				            System.out.print(", ");
				        }else {
				        	System.out.println("\n");
				        }
				    }
				    System.out.println();
				} else {
				    for (ElementiCatalogo item : itemsByAuthor) {
				        System.out.println(item.getTitle() + "\n");
				    }
				}
        
			}
			
		} while (scelta != 0);

		System.out.println("\nIl programma è terminato.");

		}
	
		private static String generateIsbn(Random random) {
	        StringBuilder sb = new StringBuilder();
	
	        for (int i = 0; i < 5; i++) {
	            int digit = random.nextInt(10);
	            sb.append(digit);
	        }
	
	        return sb.toString();
	    }
	
		public static void scriviSuFile(Catalogo catalogo, String testo, String filePath) throws IOException {
			FileWriter fileWriter = new FileWriter(filePath);
		    for (ElementiCatalogo item : catalogo.getItems()) {
		        fileWriter.write(item.toString());
		    }
		    fileWriter.close();
	        System.out.println("Testo scritto su file: " + filePath);
	    }
    
	    public static String leggiDaFile(Catalogo catalogo) throws IOException {
	    	String textFile = FileUtils.readFileToString(file, "UTF-8");
	    	if (catalogo.getItems().isEmpty()) {
	    		System.out.print("\nIl catalogo è vuoto.");
	        }else {
	        	System.out.println("\n--------Catalogo--------");	        	
	        }
	    	return textFile;
	    }

}