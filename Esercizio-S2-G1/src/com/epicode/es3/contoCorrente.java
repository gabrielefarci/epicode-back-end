package com.epicode.es3;

public class contoCorrente {
	String titolare;
    int nMovimenti;
    final int maxMovimenti = 50;
    double saldo;

    contoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        nMovimenti = 0;
    }

    void preleva(double x) throws BancaException {
        if (saldo - x < 0) {
            throw new BancaException("Il conto è in rosso");
        }

        if (nMovimenti < maxMovimenti)
            saldo = saldo - x;
        else
            saldo = saldo - x - 0.50;

        nMovimenti++;
    }

    double restituisciSaldo() {
        return saldo;
    }
}
