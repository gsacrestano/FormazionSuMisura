package org.example.entita;

public class Acquisto {

    private final int codice;
    private int costo;

    private int numLezioni;

    public Acquisto(int codice, int costo, int numLezioni) {
        this.codice = codice;
        this.costo = costo;
        this.numLezioni = numLezioni;
    }

    public int getCodice() {
        return codice;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getNumLezioni() {
        return numLezioni;
    }

    public void setNumLezioni(int numLezioni) {
        this.numLezioni = numLezioni;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "codice=" + codice +
                ", costo=" + costo +
                ", numLezioni=" + numLezioni +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Acquisto acquisto = (Acquisto) o;

        if (codice != acquisto.codice) return false;
        if (costo != acquisto.costo) return false;
        return numLezioni == acquisto.numLezioni;
    }
    
}
