package org.example.entita;

import javax.xml.crypto.Data;

public class Professore extends Account {

    public Professore(int id, String nome, String cognome, String email, String password, Indirizzo indirizzo, String data) {
        super(id, nome, cognome, email, password, indirizzo, data);
        super.uno();
    }
}
