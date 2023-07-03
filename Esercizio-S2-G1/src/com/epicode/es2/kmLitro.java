package com.epicode.es2;

public class kmLitro {
	public double calcolaKmPerLitro(double kmPercorsi, double litriConsumati) {
        if (litriConsumati == 0) {
            throw new ArithmeticException("Divisione per zero.");
        }

        return kmPercorsi / litriConsumati;
    }
}
