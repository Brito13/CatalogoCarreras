package com.example.catagolocarreras;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InicioApplication.class.getResource("Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 800);

        stage.setTitle("Catalogo de Carreras");
        stage.setScene(scene);
        //.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
