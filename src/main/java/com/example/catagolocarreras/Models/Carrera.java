/**
 * ====================================================================
 * Catálogo de Carreras UASD - Sistema de Gestión de Información Académica
 * ====================================================================
 * 
 * Archivo: Carrera.java
 * Propósito: Modelo de datos para representar una carrera universitaria
 * Autor: Equipo de Desarrollo UASD
 * Fecha: 2026-05-01
 * Versión: 1.0
 * 
 * Descripción:
 * Clase POJO que representa una carrera universitaria en el sistema.
 * Contiene la información básica de una carrera incluyendo su identificador,
 * nombre y la escuela a la que pertenece.
 * 
 * Atributos:
 * - idCarrera: Identificador único de la carrera
 * - idEscuela: Identificador de la escuela asociada
 * - nombreCarrera: Nombre completo de la carrera
 * 
 * Uso:
 * Utilizada para transferencia de datos entre capas y para mostrar información
 * en la interfaz gráfica del catálogo.
 * 
 * @author Equipo de Desarrollo UASD
 * @version 1.0
 * @since 2026-05-01
 */
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
