package org.example.entita;

import javax.xml.crypto.Data;
import java.util.Objects;

public class Lezione {

    private final int codice;
    private int tipologia;
    private String note;
    private String ora;
    private String data;

    public Lezione(int codice, int tipologia, String note, String ora, String data) {
        this.codice = codice;
        this.tipologia = tipologia;
        this.note = note;
        this.ora = ora;
        this.data = data;
    }

    public int getCodice() {
        return codice;
    }

    public int getTipologia() {
        return tipologia;
    }

    public void setTipologia(int tipologia) {
        this.tipologia = tipologia;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "codice=" + codice +
                ", tipologia='" + tipologia + '\'' +
                ", note='" + note + '\'' +
                ", ora='" + ora + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lezione lezione = (Lezione) o;

        if (codice != lezione.codice) return false;
        if (!Objects.equals(tipologia, lezione.tipologia)) return false;
        if (!Objects.equals(note, lezione.note)) return false;
        if (!Objects.equals(ora, lezione.ora)) return false;
        return Objects.equals(data, lezione.data);
    }

}
