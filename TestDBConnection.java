import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestDBConnection {
    public static void main(String[] args) {
        Properties properties = new Properties();
        
        try (InputStream input = TestDBConnection.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("No se encontró config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        
        System.out.println("URL: " + url);
        System.out.println("User: " + user);
        System.out.println("Password: " + (password != null ? "***" : "NULL"));
        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("¡Conexión exitosa!");
            System.out.println("Base de datos: " + conn.getCatalog());
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
