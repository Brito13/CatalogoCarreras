/**
 * ====================================================================
 * Catálogo de Carreras UASD - Sistema de Gestión de Información Académica
 * ====================================================================
 * 
 * Archivo: InicioApplication.java
 * Propósito: Clase principal de inicio de la aplicación JavaFX
 * Autor: Equipo de Desarrollo UASD
 * Fecha: 2026-05-01
 * Versión: 1.0
 * 
 * Descripción:
 * Clase principal que inicia la aplicación JavaFX del catálogo de carreras.
 * Carga la interfaz gráfica desde el archivo FXML y configura la ventana
 * principal del sistema.
 * 
 * Funcionalidades:
 * - Inicialización de la aplicación JavaFX
 * - Carga del archivo FXML del dashboard
 * - Configuración de la escena y ventana principal
 * - Manejo del ciclo de vida de la aplicación
 * 
 * Archivos relacionados:
 * - Dashboard.fxml: Interfaz gráfica principal
 * - DashBoardController.java: Controlador de la interfaz
 * 
 * @author Equipo de Desarrollo UASD
 * @version 1.0
 * @since 2026-05-01
 */
package com.example.catagolocarreras;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class InicioApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InicioApplication.class.getResource("Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 800);

        stage.setTitle("Catalogo de Carreras");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
