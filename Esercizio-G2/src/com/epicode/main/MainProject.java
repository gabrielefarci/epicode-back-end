package com.epicode.main;

import com.epicode.rettangolo.*;

public class MainProject {

	public static void main(String[] args) {
		
		Rettangolo r1 = new Rettangolo(42, 20);
		Rettangolo r2 = new Rettangolo(15, 30);
		
		System.out.println("Il perimetro del primo rettangolo è: " + r1.perimetro());
		System.out.println("L'area del primo rettangolo è: " + r1.area() + "\n");
		
		System.out.println("Il perimetro del primo rettangolo è: " + r1.perimetro() + ", " + "il perimetro del secondo rettangolo è: " + r2.perimetro());
		System.out.println("L'area del primo rettangolo è: " + r1.area() + ", " + "l'area del secondo rettangolo è: " + r2.area());
		
	}
	
	public static Rettangolo stampaRettangolo(int base, int altezza) {
		Rettangolo r1 = new Rettangolo();
		r1.base = base;
		r1.altezza = altezza;
		
		return r1;
	}
	
	public static Rettangolo stampaDueRettangoli(int base, int altezza) {
		Rettangolo r = new Rettangolo();
		r.base = base;
		r.altezza = altezza;
		
		return r;
	}

}
