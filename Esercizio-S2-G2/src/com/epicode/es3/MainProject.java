package com.epicode.es3;

public class MainProject {
    public static void main(String[] args) {
        RubricaTelefonica rubrica = new RubricaTelefonica();

        rubrica.inserisciContatto("Mario", "123456789");
        rubrica.inserisciContatto("Luigi", "987654321");
        rubrica.inserisciContatto("Giulia", "567890123");

        System.out.println("Ricerca contatto con numero di telefono '987654321': " + rubrica.ricercaContattoPerNumero("987654321"));
        System.out.println("Ricerca contatto di 'Mario': " + rubrica.ricercaContattoPerNome("Mario"));

        System.out.println("Contatti nella rubrica:");
        rubrica.stampaContatti();

        rubrica.cancellaContatto("Luigi");

        System.out.println("Contatti dopo la cancellazione:");
        rubrica.stampaContatti();
    }
}