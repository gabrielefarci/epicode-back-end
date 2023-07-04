package com.epicode.es3;

public class Contatto {
    private String nome;
    private String numeroTelefono;

    public Contatto(String nome, String numeroTelefono) {
        this.nome = nome;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Numero di telefono: " + numeroTelefono;
    }
}
