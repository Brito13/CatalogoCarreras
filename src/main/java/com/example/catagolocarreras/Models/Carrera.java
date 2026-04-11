package com.example.catagolocarreras.Models;

public class Carrera {
    private int idCarrera;
    private int idEscuela;
    private String nombreCarrera;
    
    public Carrera() {}
    
    public Carrera(int idCarrera, int idEscuela, String nombreCarrera) {
        this.idCarrera = idCarrera;
        this.idEscuela = idEscuela;
        this.nombreCarrera = nombreCarrera;
    }
    
    // Getters and Setters
    public int getIdCarrera() { return idCarrera; }
    public void setIdCarrera(int idCarrera) { this.idCarrera = idCarrera; }
    
    public int getIdEscuela() { return idEscuela; }
    public void setIdEscuela(int idEscuela) { this.idEscuela = idEscuela; }
    
    public String getNombreCarrera() { return nombreCarrera; }
    public void setNombreCarrera(String nombreCarrera) { this.nombreCarrera = nombreCarrera; }
    
    @Override
    public String toString() {
        return nombreCarrera;
    }
}
