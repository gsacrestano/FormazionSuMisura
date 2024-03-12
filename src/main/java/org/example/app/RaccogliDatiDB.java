package org.example.app;

import org.example.dbConnection.ConnectionDB;
import org.example.entita.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RaccogliDatiDB {

    public static String[] getMaterie() {
        String[] result = new String[3];
        int n = 0;
        Connection con = ConnectionDB.getConnection();
        String sql =
                "SELECT codice ,  nome " +
                        "FROM materie";

        System.out.println(sql);
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                result[n++] = rs.getString("codice") + " " + rs.getString("nome");


            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getArgomentiMateri(String materia) {
        String result = "";
        int n = 0;
        Connection con = ConnectionDB.getConnection();
        String sql = "SELECT A.nome" +
                " FROM materie AS M, includere as I, argomenti AS A" +
                " WHERE M.nome = '" + materia +
                "' AND M.Codice = I.MATERIE_Codice" +
                " AND A.Codice = I.ARGOMENTI_Codice";

        System.out.println(sql);
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                result = result.concat("-" + rs.getString("nome") + "\n");
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static String[] getAule() {
        String[] result = new String[3];
        int n = 0;
        Connection con = ConnectionDB.getConnection();
        String sql = "SELECT codice " +
                "FROM aule";

        System.out.println(sql);
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                result[n++] = "" + rs.getInt("codice");


            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static String[] getAquisti() {
        String[] result = new String[10];
        int n = 0;
        Connection con = ConnectionDB.getConnection();
        String sql = "SELECT A.codice, S.nome, S.cognome " +
                " FROM acquisti AS A, studenti as S" +
                " WHERE A.STUDENTI_Codice = S.Codice";

        System.out.println(sql);
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                result[n++] = rs.getInt("codice") + " " + rs.getString("nome") + " " + rs.getNString("cognome");


            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static String[] getAquisti(int codiceStudente) {
        String[] result = new String[10];
        int n = 0;
        Connection con = ConnectionDB.getConnection();
        String sql = "SELECT codice, numLezioni " +
                " FROM acquisti" +
                " WHERE STUDENTI_Codice = " + codiceStudente;

        System.out.println(sql);
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                result[n++] = rs.getInt("codice") + " Avente Lezioni N. " + rs.getString("numLezioni");


            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] getArgomenti() {
        String[] result = new String[9];
        int n = 0;
        Connection con = ConnectionDB.getConnection();
        String sql = "SELECT codice, nome" +
                " FROM argomenti";

        System.out.println(sql);
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                result[n++] = rs.getInt("codice") + " " + rs.getString("nome");


            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static String[] getCertificazioni() {
        String[] result = new String[9];
        int n = 0;
        Connection con = ConnectionDB.getConnection();
        String sql = "SELECT codice, nome" +
                " FROM certificazioni";

        System.out.println(sql);
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                result[n++] = rs.getInt("codice") + " " + rs.getString("nome");


            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static String[] getStudenti() {
        String[] result = new String[9];
        int n = 0;
        Connection con = ConnectionDB.getConnection();
        String sql = "SELECT codice, nome , cognome" +
                " FROM studenti";

        System.out.println(sql);
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                result[n++] = rs.getInt("codice") + " " + rs.getString("nome") + " " + rs.getString("cognome");


            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static String[] getLezioni(int codiceProfessore) {
        String[] result = new String[9];
        int n = 0;
        Connection con = ConnectionDB.getConnection();
        String sql = "SELECT codice, data , note" +
                " FROM lezioni WHERE PROFESSORI_Codice = " + codiceProfessore;

        System.out.println(sql);
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                result[n++] = rs.getInt("codice") + " " + rs.getString("data") + " " + rs.getString("note");


            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
