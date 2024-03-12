package org.example.app;

import org.example.dbConnection.ConnectionDB;
import org.example.entita.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoricoAcquistiQueryResult {

    public StoricoAcquistiQueryResult(String dataInizio, String dataFine, Account acc){
        this.dataInizio =dataInizio;
        this.dataFine = dataFine;
        this.acc = acc;
    }
    public String doQuery() throws SQLException {

        StringBuilder result = new StringBuilder();
        Connection con = ConnectionDB.getConnection();
        String sql = "SELECT A.data, M.nome, A.costo " +
                "FROM acquisti AS A, materie AS M " +
                "WHERE A.STUDENTI_Codice = " + acc.getId() +
                " AND A.Data >= '" + dataInizio + "' AND A.Data <= '" + dataFine + "'" +
                " AND A.MATERIE_Codice = M.codice";

        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
            result.append(rs.getString("data")).append(" ").append(rs.getString("nome")).append(" ").append(rs.getString("costo")).append("$\n");

        return result.toString();
    }


    private String dataInizio;
    private String dataFine;
    private Account acc;
}
