package com.epicode.es2;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Inserisci il numero di km percorsi: ");
            double kmPercorsi = scanner.nextDouble();

            System.out.print("Inserisci il numero di litri consumati: ");
            double litriConsumati = scanner.nextDouble();

            kmLitro calculator = new kmLitro();
            double kmPerLitro = calculator.calcolaKmPerLitro(kmPercorsi, litriConsumati);

            System.out.println("Km per litro: " + kmPerLitro);
        } catch (ArithmeticException e) {
            System.out.println("Errore: Divisione per zero.");
        }

	}

}
