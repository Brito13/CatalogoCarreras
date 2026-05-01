import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/carrerasdisponiblesuasd";
        String USER = "root";
        String PASSWORD = "Ayden020102";
        
        try {
            System.out.println("Intentando conectar...");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión exitosa!");
            System.out.println("Base de datos: " + conn.getCatalog());
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
