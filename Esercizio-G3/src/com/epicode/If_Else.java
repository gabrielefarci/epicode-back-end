package com.epicode;

public class If_Else {

	public static void main(String[] args) {
		
		String res = "Hello";
		boolean x = stringaPariDispari(res);
		System.out.println("La lunghezza della stringa è pari? " + x + "\n");
		
		
		int res2 = 2000;
		boolean y = annoBisestile(res2);
		System.out.println("L'anno è bistestile? " + y);

	}
	
	public static boolean stringaPariDispari(String stringa) {
		if(stringa.length() % 2 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean annoBisestile(int n) {
		if(n % 4 == 0) {
			if(n % 100 == 0) {
				if(n % 400 == 0) {
					return true;
				}else {
					return false;
				}
			}else {
				return true;
			}
			
		}else {
			return false;
		}
	}

}
