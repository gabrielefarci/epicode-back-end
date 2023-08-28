package com.epicode.gestioneIncendi.model;

import com.epicode.gestioneIncendi.interfaces.SondaInterface;

public class SondaFactory {
	
	public static SondaInterface creaSonda(double latitude, double longitude) {
        return new SondaProxy(latitude, longitude);
    }
	
}
