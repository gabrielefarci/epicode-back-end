package com.epicode.gestioneIncendi.model;

public class CentroDiControllo {
	
	public void notifyIncendio(Sonda sonda) {
        String message = "Incendio rilevato alla sonda. Coordinate: (" +
                sonda.getLatitude() + ", " + sonda.getLongitude() +
                "), Livello di fumo: " + sonda.getSmokeLevel();
        System.out.println(message);
    }

}
