package com.epicode;

import java.util.Scanner;

public class For {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        int numero = sc.nextInt();
        
        System.out.println("Conto alla rovescia:");
        for (int i = numero; i >= 0; i--) {
            System.out.println(i);
        }

	}

}
