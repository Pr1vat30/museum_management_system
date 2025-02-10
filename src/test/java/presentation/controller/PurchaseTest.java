package presentation.controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Presentation.Controllers.Users.ShopController;
import museum_management_system.Storage.Model.User;
import museum_management_system.Storage.Utils.DatabaseConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import static org.mockito.Mockito.*;

public class PurchaseTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private PrintWriter printWriter;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    @BeforeEach
    void setUp() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        printWriter = mock(PrintWriter.class);
        connection = mock(Connection.class);
        statement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        session = mock(HttpSession.class);
    }

    @Test
    void testInsertPurchaseSuccess() throws IOException, ServletException, SQLException {

        try (MockedStatic<DatabaseConnection> mockedDB = mockStatic(DatabaseConnection.class)) {
            mockedDB.when(DatabaseConnection::getConnection).thenReturn(connection);
            // Prepare JSON request data
            String json = new Gson().toJson(Map.of(
                    "user_password", "Ciao12345%",
                    "user_id", "1",
                    "ticket_id", "2",
                    "event_id", "3"
            ));

            // Mock HttpServletRequest and HttpServletResponse
            when(request.getParameter("op")).thenReturn("insert_purchase");

            // Mock request and response
            when(response.getWriter()).thenReturn(printWriter);
            when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

            // Mock session and user
            when(request.getSession(false)).thenReturn(session);
            User mockUser = new User();
            mockUser.setEmail("giacomo.ricco@gmail.com");
            when(session.getAttribute("user")).thenReturn(mockUser);

            // Mock  database
            when(connection.prepareStatement(anyString(), eq(PreparedStatement.RETURN_GENERATED_KEYS))).thenReturn(statement);
            when(connection.prepareStatement(anyString())).thenReturn(statement);
            when(statement.executeQuery()).thenReturn(resultSet);
            when(resultSet.next()).thenReturn(true);

            when(resultSet.getInt("user_id")).thenReturn(1);
            when(resultSet.getString("user_name")).thenReturn("Giacomo Ricco");
            when(resultSet.getString("user_email")).thenReturn("giacomo.ricco@gmail.com");
            when(resultSet.getString("user_password")).thenReturn("Ciao12345%");
            when(resultSet.getString("user_phone")).thenReturn("1234567890");

            doNothing().when(statement).close();
            doNothing().when(resultSet).close();

            // Mock testing
            ShopController shopController = new ShopController();
            shopController.doGet(request, response);

            // Verify
            verify(printWriter).println("success");
        }
    }

    @Test
    void testInsertPurchaseError() throws IOException, ServletException {
        // Prepare JSON request data
        String json = new Gson().toJson(Map.of(
                "user_password", "Ciao12345",
                "user_id", "1",
                "ticket_id", "2",
                "event_id", "3"
        ));

        // Mock HttpServletRequest and HttpServletResponse
        when(request.getParameter("op")).thenReturn("insert_purchase");

        // Mock request and response
        when(response.getWriter()).thenReturn(printWriter);
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

        // Mock session and user
        when(request.getSession(false)).thenReturn(session);
        User mockUser = new User();
        mockUser.setEmail("giacomo.ricco@gmail.com");
        when(session.getAttribute("user")).thenReturn(mockUser);

        // Mock testing
        ShopController shopController = new ShopController();
        shopController.doGet(request, response);

        // Verify
        verify(printWriter).println("error");
    }
}
