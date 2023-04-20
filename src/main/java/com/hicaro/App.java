package com.hicaro;

import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");

        String databaseUrl = "jdbc:mariadb://localhost:3306/locadora";
        String user = "hicarod0";
        String password = "password";

        Connection connection = DriverManager.getConnection(databaseUrl, user, password);

        Statement statement = connection.createStatement();
        ResultSet queryResult = statement.executeQuery("SELECT * FROM cliente");

        while (queryResult.next()) {
            String clientName = queryResult.getString("nome");
            String clientLogin = queryResult.getString("login");
            System.out.println("Login: " + clientLogin + " -- " + "Nome: " + clientName);
        }

        connection.close();
        statement.close();
    }
}