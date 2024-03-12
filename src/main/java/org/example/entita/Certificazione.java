package org.example.entita;

import java.util.Objects;

public class Certificazione {

    private final int codice;
    private String nome;

    public Certificazione(int codice, String nome) {
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

        Certificazione that = (Certificazione) o;

        if (codice != that.codice) return false;
        return Objects.equals(nome, that.nome);
    }


}
