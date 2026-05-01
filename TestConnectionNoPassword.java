import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnectionNoPassword {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/carrerasdisponiblesuasd";
        String USER = "root";
        String PASSWORD = ""; // Intentar sin contraseña
        
        try {
            System.out.println("Intentando conectar sin contraseña...");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión exitosa sin contraseña!");
            System.out.println("Base de datos: " + conn.getCatalog());
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error sin contraseña: " + e.getMessage());
            
            // Si falla, intenta con contraseña común
            try {
                PASSWORD = "root";
                System.out.println("Intentando con contraseña 'root'...");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("¡Conexión exitosa con contraseña 'root'!");
                conn.close();
            } catch (SQLException e2) {
                System.err.println("Error con contraseña 'root': " + e2.getMessage());
            }
        }
    }
}
