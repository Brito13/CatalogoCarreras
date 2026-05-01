/**
 * ====================================================================
 * Catálogo de Carreras UASD - Sistema de Gestión de Información Académica
 * ====================================================================
 * 
 * Archivo: Facultad.java
 * Propósito: Modelo de datos para representar una facultad universitaria
 * Autor: Equipo de Desarrollo UASD
 * Fecha: 2026-05-01
 * Versión: 1.0
 * 
 * Descripción:
 * Clase POJO que representa una facultad universitaria en el sistema.
 * Contiene la información básica de una facultad incluyendo su identificador
 * y nombre. Las facultades son las divisiones académicas principales de la UASD.
 * 
 * Atributos:
 * - idFacultad: Identificador único de la facultad
 * - nombreFacultad: Nombre completo de la facultad
 * 
 * Uso:
 * Utilizada para poblar el ComboBox de facultades en la interfaz gráfica
 * y como filtro para cargar las escuelas correspondientes.
 * 
 * @author Equipo de Desarrollo UASD
 * @version 1.0
 * @since 2026-05-01
 */
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
