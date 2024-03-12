package org.example.app;

import org.example.dbConnection.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AggiungiLezioneQuery {


    public AggiungiLezioneQuery(int codiceAcquisto, int numLezioni) {

        this.codiceAcquisto = codiceAcquisto;
        this.numLezioni = numLezioni;
    }

    public void doQuery() {
        Connection con = ConnectionDB.getConnection();
        String sql = "UPDATE acquisti SET NumLezioni = ? WHERE codice = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, numLezioni);
            ps.setInt(2, codiceAcquisto);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private int codiceAcquisto;
    private int numLezioni;
}
