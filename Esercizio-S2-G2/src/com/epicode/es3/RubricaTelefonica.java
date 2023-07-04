package com.epicode.es3;

import java.util.HashMap;
import java.util.Map;

public class RubricaTelefonica {
    private Map<String, Contatto> rubrica;

    public RubricaTelefonica() {
        rubrica = new HashMap<>();
    }

    public void inserisciContatto(String nome, String numeroTelefono) {
        Contatto contatto = new Contatto(nome, numeroTelefono);
        rubrica.put(nome, contatto);
    }

    public void cancellaContatto(String nome) {
        rubrica.remove(nome);
    }

    public Contatto ricercaContattoPerNumero(String numeroTelefono) {
        for (Contatto contatto : rubrica.values()) {
            if (contatto.getNumeroTelefono().equals(numeroTelefono)) {
                return contatto;
            }
        }
        return null;
    }

    public Contatto ricercaContattoPerNome(String nome) {
        return rubrica.get(nome);
    }

    public void stampaContatti() {
        for (Contatto contatto : rubrica.values()) {
            System.out.println(contatto);
        }
    }
}
