package com.epicode.es1;

import java.util.Scanner;
import java.util.Set;

public class mainProject {
    public static void main(String[] args) {
    	
        paroleManager paroleManager = new paroleManager();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero di elementi da inserire: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Inserisci la parola " + (i + 1) + ": ");
            String parola = scanner.nextLine();
            paroleManager.aggiungiParola(parola);
        }

        Set<String> paroleDuplicate = paroleManager.paroleDuplicate();
        System.out.println("Parole duplicate:");
        for (String parola : paroleDuplicate) {
            System.out.println(parola);
        }

        int numeroParoleDistinte = paroleManager.numeroParoleDistinte();
        System.out.println("Numero di parole distinte: " + numeroParoleDistinte);

        Set<String> elencoParoleDistinte = paroleManager.elencoParoleDistinte();
        System.out.println("Elenco delle parole distinte:");
        for (String parola : elencoParoleDistinte) {
            System.out.println(parola);
        }
        
    }
}
