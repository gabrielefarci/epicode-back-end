package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

	public static void main (String[] args) {
	
		System.out.println("This is my first Epicode Java Project! \n");
		
		
		//esercizio 2
		int res1 = moltiplica(7, 3);
		System.out.println("Il risultato della moltiplicazione è: " + res1 + "\n");
		
		
		String res2 = concatena("Valore: ", 42);
		System.out.println("Il risultato della concatenazione è: " + res2 +"\n");
        
        
        //esercizio 3
        Scanner sc = new Scanner(System.in);
		
    	System.out.println("Insersci la prima stringa: ");
    	String string1 = sc.nextLine();
    	
    	System.out.print("\n");
    		
    	System.out.println("Insersci la seconda stringa: ");
    	String string2 = sc.nextLine();
    	
    	System.out.print("\n");
    		
    	System.out.println("Insersci la terza stringa: ");
    	String string3 = sc.nextLine();
    	
    	System.out.print("\n");
    		
    	System.out.println("Le stringhe inserite sono: " + string1 + " " + string2 + " " + string3 + "\n");
    	System.out.println("Le stringhe inserite in ordine inverso sono: " + string3 + " " + string2 + " " + string1 + "\n");
    	
    	
    	//esercizio 4
    	perimetroRettangolo(15, 7);
    	
    	
    	int n = 3;
    	int res3 = pariDispari(n);
    	System.out.println("Il numero " + n + " è " + (res3 == 0 ? "pari" : "dispari" + "\n"));
    	
    	
    	int res4 = perimetroTriangolo(13, 27, 27);
    	System.out.println("Il perimetro del triangolo è: " + res4);
		
	}
	
	public static int moltiplica(int n1, int n2) {
		int result = n1 * n2;
		return result;
	}
	
	public static String concatena(String stringa, int n) {
		String result = stringa + n;
		return result;
	}
	
	public static String[] insersciInArray() {
		String[] array = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5", "Elemento 6"};
        return array;
	}
	
	public static void perimetroRettangolo(int n1, int n2) {
		int perimetro = (n1 + n2) * 2;
		System.out.println("Il perimetro del rettangolo è: " + perimetro + "\n");
	}
	
	public static int pariDispari(int n) {
		if(n % 2 == 0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public static int perimetroTriangolo(int n1, int n2, int n3) {
		int perimetroTriangolo = n1 + n2 + n3;
		return perimetroTriangolo;
	}	

}