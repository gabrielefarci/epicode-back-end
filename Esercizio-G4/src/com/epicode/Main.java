package com.epicode;

public class Main {

	public static void main(String[] args) {
		
		Dipendente dipendente1 = new Dipendente(123, Dipendente.Dipartimento.PRODUZIONE);
        dipendente1.stampaDatiDipendente();

        dipendente1.promuovi();
        dipendente1.stampaDatiDipendente();

        Dipendente dipendente2 = new Dipendente(456, Dipendente.Dipartimento.AMMINISTRAZIONE);
        dipendente2.stampaDatiDipendente();

        dipendente2.promuovi();
        dipendente2.stampaDatiDipendente();
        

        Dipendente.Livello nuovoLivello = dipendente2.promuovi();
        System.out.println("Nuovo livello: " + nuovoLivello);
        System.out.println("Nuovo stipendio: " + dipendente2.getStipendio());

        double pagaMensile1 = Dipendente.calcolaPaga(dipendente2);
        double pagaMensile2 = Dipendente.calcolaPaga(dipendente2, 10);
        System.out.println("Paga mensile: " + pagaMensile1);
        System.out.println("Paga mensile comprensiva di straordinario: " + pagaMensile2);

	}

}
