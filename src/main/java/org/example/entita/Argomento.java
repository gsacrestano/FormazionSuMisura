package org.example.entita;

import java.util.Objects;

public class Argomento {


    private final int codice;
    private String nome;

    public Argomento(int codice, String nome) {
        this.codice = codice;
        this.nome = nome;
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "codice=" + codice +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Argomento argomento = (Argomento) o;

        if (codice != argomento.codice) return false;
        return Objects.equals(nome, argomento.nome);
    }
}
