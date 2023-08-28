package com.epicode.gestioneIncendi.model;

import java.util.ArrayList;
import java.util.List;

import com.epicode.gestioneIncendi.interfaces.SondaObservable;

public class Sonda implements SondaObservable {
	
	private List<CentroDiControllo> observers = new ArrayList<>();
    private double latitude;
    private double longitude;
    private int smokeLevel;

    public Sonda(List<CentroDiControllo> observers, double latitude, double longitude, int smokeLevel) {
		super();
		this.observers = observers;
		this.latitude = latitude;
		this.longitude = longitude;
		this.smokeLevel = smokeLevel;
	}

	public Sonda() {
	}

	public List<CentroDiControllo> getObservers() {
		return observers;
	}


	public void setObservers(List<CentroDiControllo> observers) {
		this.observers = observers;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public int getSmokeLevel() {
		return smokeLevel;
	}


	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;
	}


	@Override
    public void addObserver(CentroDiControllo observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(CentroDiControllo observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (CentroDiControllo observer : observers) {
            observer.notifyIncendio(this);
        }
    }

    public void rilevaIncendio(int smokeLevel) {
        this.smokeLevel = smokeLevel;
        if (smokeLevel > 5) {
            notifyObservers();
        }
    }

}
