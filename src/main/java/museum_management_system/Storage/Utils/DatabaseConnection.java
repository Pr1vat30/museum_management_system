package museum_management_system.Storage.Utils;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection implements ServletContextListener {

    private static final String URL = "jdbc:mysql://localhost:3306/DbMuseum";
    private static final String USER = "root";
    private static final String PASSWORD = "Taxablebunion09@";

    public static Connection connection = null;

    public static void StartConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to database established.");
        } catch (Exception e) {
            e.printStackTrace();
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
        System.out.println("Context destroyed. Clean-up operations can be performed here.");
    }

    public static Connection getConnection() {
        return connection;
    }
}