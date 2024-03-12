package org.example.app;

import org.example.dbConnection.ConnectionDB;
import org.example.entita.Account;
import org.example.entita.Indirizzo;
import org.example.entita.Professore;
import org.example.entita.Studente;
import org.example.exception.DataProblemException;

import java.sql.*;

public class CheckData {
    public CheckData(Account data) {
        acc = data;
        if (acc.getId() == -2 || acc.getId() == -3)
            createAccount(data, acc.getId());

    }

    public Account chek() throws DataProblemException, SQLException {
        Connection con = ConnectionDB.getConnection();
        String sql = "SELECT * FROM studenti WHERE Email = ? AND Password = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, acc.getEmail());
        st.setString(2, acc.getPassword());
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            System.out.println(acc);
            return new Studente(rs.getInt("Codice"), rs.getString("Nome"), rs.getString("Cognome"), rs.getString("Email"), rs.getString("Password"), new Indirizzo(rs.getString("Via"), rs.getString("Cap"), rs.getInt("Numero")), rs.getDate("DataNascita").toString(), 0, 0);
        }
        sql = "SELECT * FROM professori WHERE Email = ? AND Password = ?";
        st = con.prepareStatement(sql);
        st.setString(1, acc.getEmail());
        st.setString(2, acc.getPassword());
        rs = st.executeQuery();
        if (rs.next()) {
            System.out.println(acc);
            return new Professore(rs.getInt("Codice"), rs.getString("Nome"), rs.getString("Cognome"), rs.getString("Email"), rs.getString("Password"), new Indirizzo(rs.getString("Via"), rs.getString("Cap"), rs.getInt("Numero")), rs.getDate("DataNascita").toString());
        }

        throw new DataProblemException("Credenziali Inesistenti");

    }


    private void createAccount(Account acc, int cas) {
        Connection connection = ConnectionDB.getConnection();
        String sql;

        if (cas == -2) {
            sql = "INSERT INTO STUDENTI(Nome, Cognome, Email, Password, DataNascita, Via, Numero, Cap, NumLezioniSvolte, NumLezioniFuture) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 0, 0)";
        } else {
            sql = "INSERT INTO PROFESSORI (Nome, Cognome, Email, Password, DataNascita, Via, Cap, Numero) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, acc.getNome());
            preparedStatement.setString(2, acc.getCognome());
            preparedStatement.setString(3, acc.getEmail());
            preparedStatement.setString(4, acc.getPassword());
            preparedStatement.setString(5, acc.getData());
            preparedStatement.setString(6, acc.getIndirizzo().getVia());
            preparedStatement.setString(7, acc.getIndirizzo().getCap());
            preparedStatement.setInt(8, acc.getIndirizzo().getCivico());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }


        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private Account acc;
}


