package com.example.catagolocarreras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/carrerasdisponiblesuasd";
    private static final String USER = "root";
    private static final String PASSWORD = "Ayden020102";    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public static void testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
                System.out.println("Base de datos: " + conn.getCatalog());
            }
        } catch (SQLException e) {
            System.err.println("Error al probar la conexión: " + e.getMessage());
        }
    }
}
