package org.example.entita;


public class Studente extends Account {

    private int lezioniSvolte;
    private int lezioniFuture;


    public Studente(int id, String nome, String cognome, String email, String password, Indirizzo indirizzo, String data, int lezioniSvolte, int lezioniFuture) {
        super(id, nome, cognome, email, password, indirizzo, data);
        this.lezioniSvolte = lezioniSvolte;
        this.lezioniFuture = lezioniFuture;

    }

    public int getLezioniSvolte() {
        return lezioniSvolte;
    }

    public void setLezioniSvolte(int lezioniSvolte) {
        this.lezioniSvolte = lezioniSvolte;
    }

    public int getLezioniFuture() {
        return lezioniFuture;
    }

    public void setLezioniFuture(int lezioniFuture) {
        this.lezioniFuture = lezioniFuture;
    }


    @Override
    public String toString() {
        return super.toString() + "{" +
                "lezioniSvolte=" + lezioniSvolte +
                ", lezioniFuture=" + lezioniFuture +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Studente studente = (Studente) o;

        if (lezioniSvolte != studente.lezioniSvolte) return false;
        return lezioniFuture == studente.lezioniFuture;

    }

}
