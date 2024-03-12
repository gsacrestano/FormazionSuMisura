package org.example.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionDB {

    ConnectionDB() {
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/dbFormazioneSuMisura";
            Connection con = DriverManager.getConnection(url, "user", "password");
            System.out.println("Connessione OK \n");
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("DB driver not found \n");
            System.out.println(e);
            return null;
        } catch (Exception e) {
            System.out.println("Connessione Fallita \n");
            System.out.println(e);
            return null;
        }

    }
}
