package org.example.entita;

import javax.xml.crypto.Data;
import java.util.Objects;

public class Account {
    private final int id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private Indirizzo indirizzo;
    private String data;

    public Account(int id, String nome, String cognome, String email, String password, Indirizzo indirizzo, String data) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.indirizzo = indirizzo;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
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
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                indirizzo +
                ", data=" + data +
                '}';
    }
    protected int uno(){
        return 1;
    }
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (!Objects.equals(nome, account.nome)) return false;
        if (!Objects.equals(cognome, account.cognome)) return false;
        if (!Objects.equals(email, account.email)) return false;
        if (!Objects.equals(password, account.password)) return false;
        if (!Objects.equals(indirizzo, account.indirizzo)) return false;
        return Objects.equals(data, account.data);
    }

}
