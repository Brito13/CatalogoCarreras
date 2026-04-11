package com.example.catagolocarreras.DAO;

import com.example.catagolocarreras.Models.Carrera;
import com.example.catagolocarreras.Models.Escuela;
import com.example.catagolocarreras.Models.Facultad;
import com.example.catagolocarreras.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarreraDAO {
    
    // Obtener todas las carreras
    public static List<Carrera> getAllCarreras() {
        List<Carrera> carreras = new ArrayList<>();
        String sql = "SELECT * FROM carreras ORDER BY Nombre_carrera";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Carrera carrera = new Carrera();
                carrera.setIdCarrera(rs.getInt("Id_carreras"));
                carrera.setIdEscuela(rs.getInt("Id_escuela"));
                carrera.setNombreCarrera(rs.getString("Nombre_carrera"));
                carreras.add(carrera);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener carreras: " + e.getMessage());
        }
        
        return carreras;
    }
    
    // Obtener todas las facultades
    public static List<Facultad> getAllFacultades() {
        List<Facultad> facultades = new ArrayList<>();
        String sql = "SELECT * FROM facultades ORDER BY Nombre_facultad";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Facultad facultad = new Facultad();
                facultad.setIdFacultad(rs.getInt("Id_facultad"));
                facultad.setNombreFacultad(rs.getString("Nombre_facultad"));
                facultad.setCantidadEscuelas(rs.getInt("Cantidad_escuelas"));
                facultad.setCantidadCarreras(rs.getInt("Cantidad_carreras"));
                facultades.add(facultad);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener facultades: " + e.getMessage());
        }
        
        return facultades;
    }
    
    // Obtener escuelas por facultad
    public static List<Escuela> getEscuelasByFacultad(int idFacultad) {
        List<Escuela> escuelas = new ArrayList<>();
        String sql = "SELECT * FROM escuelas WHERE Id_facultad = ? ORDER BY Nombre_escuela";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idFacultad);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Escuela escuela = new Escuela();
                    escuela.setIdEscuela(rs.getInt("Id_escuela"));
                    escuela.setIdFacultad(rs.getInt("Id_facultad"));
                    escuela.setNombreEscuela(rs.getString("Nombre_escuela"));
                    escuelas.add(escuela);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener escuelas: " + e.getMessage());
        }
        
        return escuelas;
    }
    
    // Obtener carreras por escuela
    public static List<Carrera> getCarrerasByEscuela(int idEscuela) {
        List<Carrera> carreras = new ArrayList<>();
        String sql = "SELECT * FROM carreras WHERE Id_escuela = ? ORDER BY Nombre_carrera";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idEscuela);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Carrera carrera = new Carrera();
                    carrera.setIdCarrera(rs.getInt("Id_carreras"));
                    carrera.setIdEscuela(rs.getInt("Id_escuela"));
                    carrera.setNombreCarrera(rs.getString("Nombre_carrera"));
                    carreras.add(carrera);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener carreras por escuela: " + e.getMessage());
        }
        
        return carreras;
    }
    
    // Buscar carreras por nombre
    public static List<Carrera> buscarCarreras(String searchTerm) {
        List<Carrera> carreras = new ArrayList<>();
        String sql = "SELECT * FROM carreras WHERE Nombre_carrera LIKE ? ORDER BY Nombre_carrera";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "%" + searchTerm + "%");
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Carrera carrera = new Carrera();
                    carrera.setIdCarrera(rs.getInt("Id_carreras"));
                    carrera.setIdEscuela(rs.getInt("Id_escuela"));
                    carrera.setNombreCarrera(rs.getString("Nombre_carrera"));
                    carreras.add(carrera);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar carreras: " + e.getMessage());
        }
        
        return carreras;
    }
}
