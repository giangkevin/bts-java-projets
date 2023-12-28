package metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
    private static Connection conn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Assignez la connexion à la variable de classe, pas à une variable locale
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/catalogue1", "root", "");
            System.out.println("Création d'une connexion");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}
