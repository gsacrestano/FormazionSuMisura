package org.example.app;

import org.example.dbConnection.ConnectionDB;
import org.example.entita.Account;
import org.example.entita.Lezione;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreaNuovaLezioneQuery {
    public CreaNuovaLezioneQuery(Account acc, Lezione lezione, int codiceClasss, int codiceAcquisto, int codiceArgomento) {
        this.acc = acc;
        this.lezione = lezione;
        this.codiceClass = codiceClasss;
        this.codiceAcquisto = codiceAcquisto;
        this.codiceArgomento = codiceArgomento;
    }

    public void doQuery() {
        Connection connection = ConnectionDB.getConnection();

        try (Statement statement = connection.createStatement()) {
            String insertLezioneQuery = "INSERT INTO LEZIONI (Tipologia, Data, Ora, Note, AULE_Codice, PROFESSORI_Codice) " +
                    "VALUES (" + "'" + lezione.getTipologia() + "', " + "'" + lezione.getData() + "', " + "'" + lezione.getOra() + "', " + "'" + lezione.getNote() + "', " + "1, " + acc.getId() + ")";

            statement.executeUpdate(insertLezioneQuery, Statement.RETURN_GENERATED_KEYS);

            // Recuperare l'ID generato per lezioni
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                int generatedLezioneId;
                if (generatedKeys.next()) {
                    generatedLezioneId = generatedKeys.getInt(1);
                    System.out.println("L'ID della lezione inserita è: " + generatedLezioneId);
                } else {
                    throw new SQLException("Errore nel recupero dell'ID della lezione.");
                }

                String insertPresenziareQuery = "INSERT INTO COMPOSTODA (ACQUISTI_Codice, LEZIONI_Codice) " + "VALUES (" + codiceAcquisto + ", " + // Sostituisci con l'ID dell'acquisto appropriato
                        generatedLezioneId + ")";
                String insertTrattatoQuery = "INSERT INTO ESSERETRATTATO (LEZIONI_Codice, ARGOMENTI_Codice) " + "VALUES (" + codiceArgomento + ", " + // Sostituisci con l'ID dell'acquisto appropriato
                        generatedLezioneId + ")";

                statement.executeUpdate(insertPresenziareQuery);
                statement.executeUpdate(insertTrattatoQuery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Lezione lezione;
    private Account acc;
    private int codiceClass;
    private int codiceAcquisto;
    private int codiceArgomento;
}

