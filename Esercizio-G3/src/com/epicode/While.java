package com.epicode;

import java.util.Scanner;

public class While {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
        String stringa;
        
        do {
            System.out.print("Inserisci una stringa: ");
            stringa = input.nextLine();
            
            if (!stringa.equals(":q")) {
                suddividiStringa(stringa);
            }
        } while (!stringa.equals(":q"));
        
	}
	
	public static void suddividiStringa(String stringa) {
        for (int i = 0; i < stringa.length(); i++) {
            System.out.print(stringa.charAt(i));
            
            if (i < stringa.length() - 1) {
                System.out.print(", ");
            }
        }
        
        System.out.println();
    }

}
