package com.epicode2;

import com.epicode.Dipendente;

public class GestioneDipendenti {

	public static void main(String[] args) {
		
        Dipendente operaio1 = new Dipendente(1, Dipendente.Dipartimento.PRODUZIONE);
        Dipendente operaio2 = new Dipendente(2, Dipendente.Dipartimento.PRODUZIONE);
        Dipendente impiegato = new Dipendente(3, Dipendente.Dipartimento.AMMINISTRAZIONE);
        Dipendente dirigente = new Dipendente(4, Dipendente.Dipartimento.VENDITE);

        System.out.println("Stato iniziale dei dipendenti:");
        System.out.println("-----------------------------");
        operaio1.stampaDatiDipendente();
        operaio2.stampaDatiDipendente();
        impiegato.stampaDatiDipendente();
        dirigente.stampaDatiDipendente();
        System.out.println();

        operaio1.promuovi();

	}

}
