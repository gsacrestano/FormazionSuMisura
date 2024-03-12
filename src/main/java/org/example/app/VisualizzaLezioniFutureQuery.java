package org.example.app;

import org.example.dbConnection.ConnectionDB;
import org.example.entita.Account;
import org.example.entita.Studente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VisualizzaLezioniFutureQuery {

        public VisualizzaLezioniFutureQuery(Account acc) {
            this.acc = acc;
        }

        public ArrayList<String> doQuery() throws SQLException {

            ArrayList<String> result = new ArrayList<>();
            Connection con = ConnectionDB.getConnection();
            String sql = "";
            if (acc.getClass() == Studente.class) {
                sql = "SELECT L.data, L.tipologia, L.note " +
                        "FROM lezioni AS L, Acquisti AS A, Compostoda AS C" +
                        " WHERE L.data >= '" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "'"+
                        " AND A.STUDENTI_Codice =" + acc.getId() + " AND A.Codice = C.ACQUISTI_Codice AND C.LEZIONI_Codice = L.Codice";
            }
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                result.add(rs.getString("data").concat(" ").concat(rs.getString("tipologia")).concat(" ").concat(rs.getString("note")).concat(""));

            return result;
        }


        private Account acc;
    }


