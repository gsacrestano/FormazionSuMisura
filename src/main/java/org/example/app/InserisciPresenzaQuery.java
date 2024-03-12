package org.example.app;

import org.example.dbConnection.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserisciPresenzaQuery {

    public InserisciPresenzaQuery(int codiceStudente, int codiceLezione) {
        this.codiceLezione = codiceLezione;
        this.codiceStudente = codiceStudente;

    }


    public void doQuery() {
        Connection con = ConnectionDB.getConnection();
        String sql = "INSERT INTO PRESENZIAREA (STUDENTI_Codice, LEZIONI_Codice) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codiceStudente);
            ps.setInt(2, codiceLezione);

            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }


    private int codiceLezione;
    private int codiceStudente;
}
