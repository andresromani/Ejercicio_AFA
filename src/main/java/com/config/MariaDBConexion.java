package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConexion {
    private Connection con;
    private String host = "jdbc:mariadb://localhost:3306/afa";
    private String user = "root";
    private String pass = "";
    
    public MariaDBConexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(host, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public Connection getCon() {
        return con;
    }
}
