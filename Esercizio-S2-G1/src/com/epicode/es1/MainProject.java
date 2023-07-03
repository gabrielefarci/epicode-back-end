package com.epicode.es1;

import java.util.Arrays;
import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		
		ArrayManager arrayManager = new ArrayManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Array iniziale: " + Arrays.toString(arrayManager.getArray()));

        while (true) {
            try {
                System.out.print("Inserisci un numero (0 per uscire): ");
                int numero = scanner.nextInt();

                if (numero == 0) {
                    break;
                }

                System.out.print("Inserisci la posizione (0-4): ");
                int posizione = scanner.nextInt();

                arrayManager.updateArray(numero, posizione);

                System.out.println("Nuovo stato dell'array: " + Arrays.toString(arrayManager.getArray()));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Errore: Posizione non valida. Riprova");
                scanner.nextLine();
            }
        }

        System.out.println("Programma terminato.");
    }

}
