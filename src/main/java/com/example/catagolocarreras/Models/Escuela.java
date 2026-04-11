package com.example.catagolocarreras.Models;

public class Escuela {
    private int idEscuela;
    private int idFacultad;
    private String nombreEscuela;
    
    public Escuela() {}
    
    public Escuela(int idEscuela, int idFacultad, String nombreEscuela) {
        this.idEscuela = idEscuela;
        this.idFacultad = idFacultad;
        this.nombreEscuela = nombreEscuela;
    }
    
    // Getters and Setters
    public int getIdEscuela() { return idEscuela; }
    public void setIdEscuela(int idEscuela) { this.idEscuela = idEscuela; }
    
    public int getIdFacultad() { return idFacultad; }
    public void setIdFacultad(int idFacultad) { this.idFacultad = idFacultad; }
    
    public String getNombreEscuela() { return nombreEscuela; }
    public void setNombreEscuela(String nombreEscuela) { this.nombreEscuela = nombreEscuela; }
    
    @Override
    public String toString() {
        return nombreEscuela;
    }
}
