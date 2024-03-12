package org.example.app;

import org.example.dbConnection.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AggiungiCertificazione {
    public AggiungiCertificazione(int codiceProfessore, int codiceCertificazione) {
        this.codiceProfessore = codiceProfessore;
        this.codiceCertificazione = codiceCertificazione;
    }

    public void doQuery() {
        Connection con = ConnectionDB.getConnection();
        String sql = "INSERT INTO POSSEDERE(PROFESSORI_Codice, CERTIFICAZIONI_Codice) VALUES (?, ?)";

        System.out.println(sql); // Log the SQL statement for debugging (optional)

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codiceProfessore);
            ps.setInt(2, codiceCertificazione);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    private int codiceProfessore;
    private int codiceCertificazione;
}
