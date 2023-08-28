package com.epicode.gestioneIncendi.interfaces;

import com.epicode.gestioneIncendi.model.CentroDiControllo;

public interface SondaObservable {
	
	void addObserver(CentroDiControllo observer);
    void removeObserver(CentroDiControllo observer);

}
