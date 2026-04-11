module com.example.catagolocarreras {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.catagolocarreras to javafx.fxml;
    exports com.example.catagolocarreras;
    exports com.example.catagolocarreras.Controllers;
    exports com.example.catagolocarreras.Models;
    exports com.example.catagolocarreras.DAO;
    opens com.example.catagolocarreras.Controllers to javafx.fxml;
}