package com.epicode.es1;

import java.util.HashSet;
import java.util.Set;

public class paroleManager implements set {
    private Set<String> parole;
    private Set<String> paroleDuplicate;

    public paroleManager() {
        parole = new HashSet<>();
        paroleDuplicate = new HashSet<>();
    }

    @Override
    public void aggiungiParola(String parola) {
        if (!parole.add(parola)) {
            paroleDuplicate.add(parola);
        }
    }

    @Override
    public Set<String> paroleDuplicate() {
        return paroleDuplicate;
    }

    @Override
    public int numeroParoleDistinte() {
        return parole.size();
    }

    @Override
    public Set<String> elencoParoleDistinte() {
        return parole;
    }
}