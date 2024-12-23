package museum_management_system.Storage.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Parametri per la connessione al database
    private static final String URL = "jdbc:mysql://localhost:3306/unveiled_wine";
    private static final String USERNAME = "admin"; // Sostituisci con l'utente del tuo database
    private static final String PASSWORD = "admin"; // Sostituisci con la password del tuo database

    private static Connection connection;

    // Metodo per ottenere la connessione al database
    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
    }
}
