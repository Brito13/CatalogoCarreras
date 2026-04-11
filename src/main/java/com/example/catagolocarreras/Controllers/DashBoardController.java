package com.example.catagolocarreras.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class DashBoardController {
    @FXML
    private Label welcomeText;
    
    @FXML
    private AnchorPane titleBar;
    
    @FXML
    private AnchorPane resizeCorner;
    
    @FXML
    private BorderPane mainPane;

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
}
