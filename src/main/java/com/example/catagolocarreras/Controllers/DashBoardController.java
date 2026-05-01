/**
 * ====================================================================
 * Catálogo de Carreras UASD - Sistema de Gestión de Información Académica
 * ====================================================================
 * 
 * Archivo: DashBoardController.java
 * Propósito: Controlador principal de la interfaz gráfica del dashboard
 * Autor: Equipo de Desarrollo UASD
 * Fecha: 2026-05-01
 * Versión: 1.0
 * 
 * Descripción:
 * Controlador JavaFX que gestiona la interfaz principal del catálogo de carreras.
 * Maneja la carga de datos desde la base de datos, la interacción con componentes
 * de la interfaz (ComboBox, TableView, TextField) y la funcionalidad de búsqueda.
 * 
 * Características principales:
 * - Carga dinámica de facultades y escuelas
 * - Filtrado de carreras por facultad/escuela
 * - Búsqueda de carreras por nombre
 * - Gestión de eventos de la interfaz
 * - Animaciones y efectos visuales
 * 
 * Componentes gestionados:
 * - ComboBox de Facultades (comboFacultades)
 * - ComboBox de Escuelas (comboEscuelas)
 * - TableView de Carreras (tableViewCarreras)
 * - Campo de búsqueda (txtBuscar)
 * - Botón de búsqueda (btnBuscar)
 * 
 * @author Equipo de Desarrollo UASD
 * @version 1.0
 * @since 2026-05-01
 */
package com.example.catagolocarreras.Controllers;

import com.example.catagolocarreras.DAO.CarreraDAO;
import com.example.catagolocarreras.Models.Carrera;
import com.example.catagolocarreras.Models.Facultad;
import com.example.catagolocarreras.Models.Escuela;
import com.example.catagolocarreras.DatabaseConnection;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    @FXML
    private Label welcomeText;

    @FXML
    private AnchorPane titleBar;

    @FXML
    private AnchorPane resizeCorner;

    @FXML
    private BorderPane mainPane;

    @FXML
    private TableView<Carrera> tableViewCarreras;

    @FXML
    private ComboBox<Facultad> comboFacultades;

    @FXML
    private ComboBox<Escuela> comboEscuelas;

    @FXML
    private TextField txtBuscar;

    @FXML
    private Button btnBuscar;

    // Botones de ventana

    @FXML
    protected void handleClose() {
        System.exit(0);
    }

    @FXML
    protected void handleMinimize() {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.setIconified(true);
    }

    // Arrastrar ventana

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    protected void handleMousePressed(MouseEvent event) {
        if (event.getSource() instanceof Button) return;
        Stage stage = (Stage) mainPane.getScene().getWindow();
        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
    }

    @FXML
    protected void handleMouseDragged(MouseEvent event) {
        if (event.getSource() instanceof Button) return;
        Stage stage = (Stage) mainPane.getScene().getWindow();
        stage.setX(event.getScreenX() + xOffset);
        stage.setY(event.getScreenY() + yOffset);
    }

    // Redimensionar ventana 

    @FXML
    protected void handleResizePressed(MouseEvent event) {

    }

    @FXML
    protected void handleResizeDragged(MouseEvent event) {
        Stage stage = (Stage) ((AnchorPane) event.getSource()).getScene().getWindow();
        stage.setWidth(event.getSceneX());
        stage.setHeight(event.getSceneY());
    }

    // Inicialización 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Inicializando DashBoardController...");
        DatabaseConnection.testConnection();
        setupTableView();
        // Cargar datos de la base de datos
        cargarFacultades();
        cargarCarreras();
        System.out.println("DashBoardController inicializado con datos de BD");
    }

    private void setupTableView() {
        TableColumn<Carrera, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idCarrera"));
        idColumn.setPrefWidth(50);

        TableColumn<Carrera, String> nombreColumn = new TableColumn<>("Nombre de Carrera");
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombreCarrera"));
        nombreColumn.setPrefWidth(300);

        tableViewCarreras.getColumns().addAll(idColumn, nombreColumn);
    }

    // Carga de datos 

    private void cargarFacultades() {
        List<Facultad> facultades = CarreraDAO.getAllFacultades();
        comboFacultades.getItems().addAll(facultades);

        comboFacultades.setOnAction(event -> {
            Facultad selectedFacultad = comboFacultades.getValue();
            if (selectedFacultad != null) {
                cargarEscuelasPorFacultad(selectedFacultad.getIdFacultad());
            }
        });
    }

    private void cargarEscuelasPorFacultad(int idFacultad) {
        comboEscuelas.getItems().clear();
        List<Escuela> escuelas = CarreraDAO.getEscuelasByFacultad(idFacultad);
        comboEscuelas.getItems().addAll(escuelas);

        comboEscuelas.setOnAction(event -> {
            Escuela selectedEscuela = comboEscuelas.getValue();
            if (selectedEscuela != null) {
                cargarCarrerasPorEscuela(selectedEscuela.getIdEscuela());
            }
        });
    }

    private void cargarCarrerasPorEscuela(int idEscuela) {
        List<Carrera> carreras = CarreraDAO.getCarrerasByEscuela(idEscuela);
        tableViewCarreras.getItems().clear();
        tableViewCarreras.getItems().addAll(carreras);
    }

    private void cargarCarreras() {
        List<Carrera> carreras = CarreraDAO.getAllCarreras();
        tableViewCarreras.getItems().clear();
        tableViewCarreras.getItems().addAll(carreras);
    }

    // Busqueda 

    @FXML
    protected void handleBuscar() {
        String searchTerm = txtBuscar.getText().trim();

        if (searchTerm.isEmpty()) {
            cargarCarreras();
            // welcomeText.setText("Mostrando todas las carreras ("
            //         + tableViewCarreras.getItems().size() + " carreras encontradas)");
            System.out.println("Mostrando todas las carreras (" + tableViewCarreras.getItems().size() + " carreras encontradas)");
        } else {
            List<Carrera> carrerasEncontradas = CarreraDAO.buscarCarreras(searchTerm);
            tableViewCarreras.getItems().clear();
            tableViewCarreras.getItems().addAll(carrerasEncontradas);

            if (carrerasEncontradas.isEmpty()) {
                // welcomeText.setText("No se encontraron carreras con: '" + searchTerm + "'");
                System.out.println("No se encontraron carreras con: '" + searchTerm + "'");
            } else {
                // welcomeText.setText("Se encontraron " + carrerasEncontradas.size()
                //         + " carreras con: '" + searchTerm + "'");
                System.out.println("Se encontraron " + carrerasEncontradas.size() + " carreras con: '" + searchTerm + "'");
            }
        }

        // Animación del botón: verde por 1 segundo, luego vuelve al color original
        btnBuscar.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;");

        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e ->
            btnBuscar.setStyle("-fx-background-color: #4e73df; -fx-text-fill: white;")
        );
        pause.play();
    }
}