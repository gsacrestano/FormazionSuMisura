package org.example.app;

import org.example.dbConnection.ConnectionDB;
import org.example.entita.Acquisto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreaAcquistoQuery {

    public CreaAcquistoQuery(Acquisto acquisto, int codiceStudente, int codiceMateria) {

        this.acquisto = acquisto;
        this.codiceMateria = codiceMateria;
        this.codiceStudente = codiceStudente;
    }

    public void doQuery() {
        Connection con = ConnectionDB.getConnection();
        String sql = "INSERT INTO ACQUISTI(Costo, NumLezioni, STUDENTI_Codice, MATERIE_Codice, Data, Sconto) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setFloat(1, (float) acquisto.getCosto());
            ps.setInt(2, acquisto.getNumLezioni());
            ps.setInt(3, codiceStudente);
            ps.setInt(4, codiceMateria);
            ps.setString(5, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            ps.setInt(6, 0);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    private Acquisto acquisto;
    private int codiceStudente;
    private int codiceMateria;
}

