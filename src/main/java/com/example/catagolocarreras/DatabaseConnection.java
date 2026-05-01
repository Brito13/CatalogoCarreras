package com.example.catagolocarreras;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Properties properties = new Properties();
    
    static {
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("No se encontró config.properties, usando valores por defecto");
                properties.setProperty("db.url", "jdbc:mysql://localhost:3306/carrerasdisponiblesuasd");
                properties.setProperty("db.username", "root");
                properties.setProperty("db.password", "100200300"); // Contraseña temporal
            } else {
                properties.load(input);
                System.out.println("config.properties cargado correctamente");
                System.out.println("URL: " + properties.getProperty("db.url"));
                System.out.println("User: " + properties.getProperty("db.username"));
                System.out.println("Password: " + (properties.getProperty("db.password") != null ? "***" : "NULL"));
            }
        } catch (IOException ex) {
            System.err.println("Error al cargar config.properties: " + ex.getMessage());
            // Usar valores por defecto en caso de error
            properties.setProperty("db.url", "jdbc:mysql://localhost:3306/carrerasdisponiblesuasd");
            properties.setProperty("db.username", "root");
            properties.setProperty("db.password", "100200300");
            ex.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        try {
            // Cargar el driver de MySQL explícitamente
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver de MySQL no encontrado: " + e.getMessage());
            e.printStackTrace();
            return null;
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
