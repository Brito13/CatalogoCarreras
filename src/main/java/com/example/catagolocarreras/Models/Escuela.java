/**
 * ====================================================================
 * Catálogo de Carreras UASD - Sistema de Gestión de Información Académica
 * ====================================================================
 * 
 * Archivo: Escuela.java
 * Propósito: Modelo de datos para representar una escuela universitaria
 * Autor: Equipo de Desarrollo UASD
 * Fecha: 2026-05-01
 * Versión: 1.0
 * 
 * Descripción:
 * Clase POJO que representa una escuela universitaria en el sistema.
 * Contiene la información básica de una escuela incluyendo su identificador,
 * nombre, y la facultad a la que pertenece. Las escuelas son subdivisiones
 * académicas dentro de las facultades.
 * 
 * Atributos:
 * - idEscuela: Identificador único de la escuela
 * - idFacultad: Identificador de la facultad asociada
 * - nombreEscuela: Nombre completo de la escuela
 * 
 * Uso:
 * Utilizada para poblar el ComboBox de escuelas en la interfaz gráfica
 * y como filtro para cargar las carreras correspondientes.
 * 
 * @author Equipo de Desarrollo UASD
 * @version 1.0
 * @since 2026-05-01
 */
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
