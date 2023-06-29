package com.epicode.rettangolo;

public class Rettangolo {
	
	public int base;
	public int altezza;
	
	public Rettangolo() {}
	
	public Rettangolo(int base, int altezza) {
		this.base = base;
		this.altezza = altezza;
	}
	
	public int perimetro() {
		return (this.base + this.altezza) * 2;
	}
	
	public int area() {
		return this.base * this.altezza;
	}

}
