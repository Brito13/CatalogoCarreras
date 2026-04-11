package com.example.catagolocarreras.Controllers;

import com.example.catagolocarreras.DAO.CarreraDAO;
import com.example.catagolocarreras.Models.Carrera;
import com.example.catagolocarreras.Models.Facultad;
import com.example.catagolocarreras.Models.Escuela;
import com.example.catagolocarreras.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    
    @FXML
    protected void handleClose() {
        System.exit(0);
    }
    
    @FXML
    protected void handleMinimize() {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.setIconified(true);
    }
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    @FXML
    protected void handleMousePressed(MouseEvent event) {
        // No permitir arrastrar si el clic es en los botones
        if (event.getSource() instanceof Button) return;
        
        Stage stage = (Stage) mainPane.getScene().getWindow();
        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
    }
    
    @FXML
    protected void handleMouseDragged(MouseEvent event) {
        // No permitir arrastrar si el clic es en los botones
        if (event.getSource() instanceof Button) return;
        
        Stage stage = (Stage) mainPane.getScene().getWindow();
        stage.setX(event.getScreenX() + xOffset);
        stage.setY(event.getScreenY() + yOffset);
    }
    
    @FXML
    protected void handleResizePressed(MouseEvent event) {
        // No necesitamos offset para redimensionar
    }
    
    @FXML
    protected void handleResizeDragged(MouseEvent event) {
        Stage stage = (Stage) ((AnchorPane) event.getSource()).getScene().getWindow();
        stage.setWidth(event.getSceneX());
        stage.setHeight(event.getSceneY());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Probar conexión a la base de datos
        DatabaseConnection.testConnection();
        
        // Configurar tabla
        setupTableView();
        
        // Cargar datos iniciales
        cargarFacultades();
        cargarCarreras();
    }
    
    private void setupTableView() {
        // Configurar columnas de la tabla
        TableColumn<Carrera, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idCarrera"));
        idColumn.setPrefWidth(50);
        
        TableColumn<Carrera, String> nombreColumn = new TableColumn<>("Nombre de Carrera");
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombreCarrera"));
        nombreColumn.setPrefWidth(300);
        
        tableViewCarreras.getColumns().addAll(idColumn, nombreColumn);
    }
    
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
    
    @FXML
    protected void handleBuscar() {
        String searchTerm = txtBuscar.getText().trim();
        
        if (searchTerm.isEmpty()) {
            // Si no hay texto de búsqueda, mostrar todas las carreras
            cargarCarreras();
            welcomeText.setText("Mostrando todas las carreras (" + tableViewCarreras.getItems().size() + " carreras encontradas)");
        } else {
            // Buscar carreras por nombre
            List<Carrera> carrerasEncontradas = CarreraDAO.buscarCarreras(searchTerm);
            tableViewCarreras.getItems().clear();
            tableViewCarreras.getItems().addAll(carrerasEncontradas);
            
            if (carrerasEncontradas.isEmpty()) {
                welcomeText.setText("No se encontraron carreras con: '" + searchTerm + "'");
            } else {
                welcomeText.setText("Se encontraron " + carrerasEncontradas.size() + " carreras con: '" + searchTerm + "'");
            }
        }
        
        // Resaltar el botón buscar para mostrar que funciona
        btnBuscar.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;");
        
        // Volver al color original después de 1 segundo
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                javafx.application.Platform.runLater(() -> {
                    btnBuscar.setStyle("-fx-background-color: #4e73df; -fx-text-fill: white;");
                });
            }
        }, 1000);
    }
}
