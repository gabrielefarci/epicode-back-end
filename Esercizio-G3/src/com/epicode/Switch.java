package com.epicode;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci un intero: ");
        int numero = sc.nextInt();
        
        switch(numero) {
        case 0:
            System.out.println("Zero");
            break;
        case 1:
            System.out.println("Uno");
            break;
        case 2:
            System.out.println("Due");
            break;
        case 3:
            System.out.println("Tre");
            break;
        default:
            System.out.println("Valore non valido. Inserisci un numero compreso tra 0 e 3.");
    }

	}

}
