package com.example.catagolocarreras.Models;

public class Facultad {
    private int idFacultad;
    private String nombreFacultad;
    private int cantidadEscuelas;
    private int cantidadCarreras;
    
    public Facultad() {}
    
    public Facultad(int idFacultad, String nombreFacultad, int cantidadEscuelas, int cantidadCarreras) {
        this.idFacultad = idFacultad;
        this.nombreFacultad = nombreFacultad;
        this.cantidadEscuelas = cantidadEscuelas;
        this.cantidadCarreras = cantidadCarreras;
    }
    
    // Getters and Setters
    public int getIdFacultad() { return idFacultad; }
    public void setIdFacultad(int idFacultad) { this.idFacultad = idFacultad; }
    
    public String getNombreFacultad() { return nombreFacultad; }
    public void setNombreFacultad(String nombreFacultad) { this.nombreFacultad = nombreFacultad; }
    
    public int getCantidadEscuelas() { return cantidadEscuelas; }
    public void setCantidadEscuelas(int cantidadEscuelas) { this.cantidadEscuelas = cantidadEscuelas; }
    
    public int getCantidadCarreras() { return cantidadCarreras; }
    public void setCantidadCarreras(int cantidadCarreras) { this.cantidadCarreras = cantidadCarreras; }
    
    @Override
    public String toString() {
        return nombreFacultad;
    }
}
