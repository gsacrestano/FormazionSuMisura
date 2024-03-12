package org.example.entita;

import java.util.Objects;

public class Materia {

    private final int codice;
    private String nome;

    public Materia(int codice, String nome) {
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

        Materia materia = (Materia) o;

        if (codice != materia.codice) return false;
        return Objects.equals(nome, materia.nome);
    }
}
