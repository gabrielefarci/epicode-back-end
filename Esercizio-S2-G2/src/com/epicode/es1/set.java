package com.epicode.es1;
import java.util.Set;

public interface set {
	
    void aggiungiParola(String parola);
    Set<String> paroleDuplicate();
    int numeroParoleDistinte();
    Set<String> elencoParoleDistinte();
    
}