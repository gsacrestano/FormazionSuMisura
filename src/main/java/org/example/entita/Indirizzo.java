package org.example.entita;

public class Indirizzo {

    private String via;
    private String cap;
    private int civico;

    public Indirizzo(String via, String cap, int civico) {
        this.via = via;
        this.cap = cap;
        this.civico = civico;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public int getCivico() {
        return civico;
    }

    public void setCivico(int civico) {
        this.civico = civico;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "via='" + via + '\'' +
                ", cap=" + cap +
                ", civico=" + civico +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Indirizzo indirizzo = (Indirizzo) o;

        if (cap != indirizzo.cap) return false;
        if (civico != indirizzo.civico) return false;
        return via.equals(indirizzo.via);
    }

}
