package org.example.entita;

public class BustaPaga {

    private final int Codice;
    private int mese;
    private int stipendio;
    private int bonus = 0;

    public BustaPaga(int codice, int mese, int stipendio) {
        Codice = codice;
        this.mese = mese;
        this.stipendio = stipendio;
    }

    public int getCodice() {
        return Codice;
    }

    public int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public int getStipendio() {
        return stipendio;
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "Codice=" + Codice +
                ", mese=" + mese +
                ", stipendio=" + stipendio +
                ", bonus=" + bonus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BustaPaga bustaPaga = (BustaPaga) o;

        if (Codice != bustaPaga.Codice) return false;
        if (mese != bustaPaga.mese) return false;
        if (stipendio != bustaPaga.stipendio) return false;
        return bonus == bustaPaga.bonus;
    }
    
}
