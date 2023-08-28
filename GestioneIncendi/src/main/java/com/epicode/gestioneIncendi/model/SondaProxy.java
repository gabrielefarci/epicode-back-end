package com.epicode.gestioneIncendi.model;

import com.epicode.gestioneIncendi.interfaces.SondaInterface;

public class SondaProxy implements SondaInterface {
	
	private Sonda sonda;

    public SondaProxy(double latitude, double longitude) {
        sonda = new Sonda();
        sonda.setLatitude(latitude);
        sonda.setLongitude(longitude);
    }

    @Override
    public void rilevaFumo(int smokeLevel) {
        sonda.rilevaIncendio(smokeLevel);
    }

}
