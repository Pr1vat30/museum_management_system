package museum_management_system.Storage.Util;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;



public class DatabaseUtil implements ServletContextListener {

    private static final String URL = "jdbc:mysql://localhost:3306/museo";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static Connection connection = null;

    public static void StartConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to database established.");
        } catch (Exception e) {
            System.out.println("<ERRORE DI CONNESSIONE NEL METODO STARTCONNECTION>" + e.getStackTrace());
            throw new RuntimeException("Database connection failed.");
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing database connection...");
        try {
            StartConnection();
        } catch (Exception e) {
            System.err.println("Failed to connect to the database during startup.");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        // De-register JDBC driver to prevent memory leaks
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                if (driver.getClass().getClassLoader() == getClass().getClassLoader()) {
                    DriverManager.deregisterDriver(driver);
                }
            } catch (SQLException e) {
                System.out.println("<ERRORE DI CONNESSIONE NEL METODO CONTEXTDESTROYED>" + e.getStackTrace());
            }
        }

        // Shutdown mysql-cj-abandoned-connection-cleanup thread
        // Chiude in sicurezza il thread di cleanup
        com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();

        System.out.println("Context destroyed. Clean-up operations can be performed here.");
    }
}
