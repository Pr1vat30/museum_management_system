package presentation.controller;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Application.Facade.SignupFacade;
import museum_management_system.Application.Service.SignupService;
import museum_management_system.Presentation.Controllers.SignupController;
import museum_management_system.Storage.Model.PayMethod;
import museum_management_system.Storage.Model.User;
import museum_management_system.Storage.Utils.DatabaseConnection;
import museum_management_system.Storage.Utils.UserValidator;
import org.junit.jupiter.api.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.mockito.MockedStatic;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SignupTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private PrintWriter printWriter;
    private static ExtentReports extent;
    private ExtentTest test;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    @BeforeAll
    static void setupExtent() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-reports/SignupTestReport.html");
        spark.config().setDocumentTitle("SignupControl Test Report");
        spark.config().setReportName("Test di SignupControl");
        spark.config().setTimelineEnabled(true);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Barone Angelo");
        extent.setSystemInfo("Ambiente", "Test");
    }

    @BeforeEach
    void setUp(TestInfo testinfo) {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        printWriter = mock(PrintWriter.class);
        connection = mock(Connection.class);
        statement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        session = mock(HttpSession.class);
        test = extent.createTest(testinfo.getDisplayName());
    }

    // TC_VIS_1: LN1 - Username Troppo lungo
    @Test
    void testInvalidName() throws Exception {
        String json = new Gson().toJson(Map.of(
                "username", "Gihajshsjajhsjshajhsjsahsjahjahsjahjshasjhsajahshajash",
                "email", "giacomo.ricco@gmail.com",
                "password", "Ciao12345@",
                "c_password", "Ciao12345@",
                "phone", "1234567890",
                "card_number", "2345897678367382",
                "card_expiry_date", "11/27",
                "card_secret_code", "234"
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        SignupController controller = new SignupController();
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Nome troppo lungo");
    }

    // TC_VIS_2: LN2, FNN1 - Username che non rispetta il formato
    @Test
    void testInvalidUsernameCharacters() throws Exception {
        String json = new Gson().toJson(Map.of(
                "username", "Giac1",
                "email", "giacomo.ricco@gmail.com",
                "password", "Ciao12345@",
                "c_password", "Ciao12345@",
                "phone", "1234567890",
                "card_number", "2345897678367382",
                "card_expiry_date", "11/27",
                "card_secret_code", "234"
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        SignupController controller = new SignupController();
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Username che non rispetta il formato");
    }

    // TC_VIS_3: LN2, FNN2, FNP1 - Formato password non valido
    @Test
    void testInvalidPasswordFormat() throws Exception {
        String json = new Gson().toJson(Map.of(
                "username", "Giacomo Ricco",
                "email", "giacomo.ricco@gmail.com",
                "password", "Ciao12345",
                "c_password", "Ciao12345",
                "phone", "1234567890",
                "card_number", "2345897678367382",
                "card_expiry_date", "11/27",
                "card_secret_code", "234"
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        SignupController controller = new SignupController();
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Formato password non valido");
    }

    // TC_VIS_4: LN2, FNN2, LP1, FNP1 - Lunghezza password non valida (meno di 6 caratteri)
    @Test
    void testInvalidPasswordLength() throws Exception {
        String json = new Gson().toJson(Map.of(
                "username", "Giacomo Ricco",
                "email", "giacomo.ricco@gmail.com",
                "password", "Ci",
                "c_password", "Ci",
                "phone", "1234567890",
                "card_number", "2345897678367382",
                "card_expiry_date", "11/27",
                "card_secret_code", "234"
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        SignupController controller = new SignupController();
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Lunghezza password non valida (meno di 6 caratteri)");
    }

    // TC_VIS_5: LN2, FNN2, LP2, FNP2, MCP1 - La password non coincide con la conferma
    @Test
    void testInvalidPasswordCheck() throws Exception {
        String json = new Gson().toJson(Map.of(
                "username", "Giacomo Ricco",
                "email", "giacomo.ricco@gmail.com",
                "password", "Ciao12345%",
                "c_password", "Ciao",
                "phone", "1234567890",
                "card_number", "2345897678367382",
                "card_expiry_date", "11/27",
                "card_secret_code", "234"
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        SignupController controller = new SignupController();
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: La password non coincide con la conferma");
    }

    // TC_VIS_6: LN2, FNN2, FNP2, MCP2, FNE1 - Formato email non valido
    @Test
    void testInvalidEmailFormat() throws Exception {
        String json = new Gson().toJson(Map.of(
                "username", "Giacomo Ricco",
                "email", "Shshshsjsdhjd",
                "password", "Ciao12345@",
                "c_password", "Ciao12345@",
                "phone", "1234567890",
                "card_number", "2345897678367382",
                "card_expiry_date", "11/27",
                "card_secret_code", "234"
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        SignupController controller = new SignupController();
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Formato email non valido");
    }

    // TC_VIS_7: LN2, FNN2, FNP2, MCP2, FNE2, FNT1 - Il numero di telefono non rispetta il formato
    @Test
    void testInvalidPhoneNumber() throws Exception {
        String json = new Gson().toJson(Map.of(
                "username", "Giacomo Ricco",
                "email", "giacomo.ricco@gmail.com",
                "password", "Ciao12345@",
                "c_password", "Ciao12345@",
                "phone", "338abc",
                "card_number", "2345897678367382",
                "card_expiry_date", "11/27",
                "card_secret_code", "234"
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        SignupController controller = new SignupController();
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Il numero di telefono non rispetta il formato");
    }

    // TC_VIS_8: LN2, FNN2, FNP2, MCP2, FNE2, FNT2, FNC1 - Il numero della carta di credito non rispetta il formato
    @Test
    void testInvalidCardNumber() throws Exception {
        String json = new Gson().toJson(Map.of(
                "username", "Giacomo Ricco",
                "email", "giacomo.ricco@gmail.com",
                "password", "Ciao12345@",
                "c_password", "Ciao12345@",
                "phone", "1234567890",
                "card_number", "23458",
                "card_expiry_date", "11/27",
                "card_secret_code", "234"
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        SignupController controller = new SignupController();
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Il numero della carta di credito non rispetta il formato");
    }

    // TC_VIS_9: LN2, FNN2, FNP2, MCP2, FNE2, FNT2, FNC2, FND1 - Data di scadenza della carta non valida
    @Test
    void testInvalidCardExpiryDate() throws Exception {
        String json = new Gson().toJson(Map.of(
                "username", "Giacomo Ricco",
                "email", "giacomo.ricco@gmail.com",
                "password", "Ciao12345@",
                "c_password", "Ciao12345@",
                "phone", "1234567890",
                "card_number", "2345897678367382",
                "card_expiry_date", "24/1",
                "card_secret_code", "234"
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        SignupController controller = new SignupController();
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Data di scadenza della carta non valida");
    }

    // TC_VIS_10: LN2, FNN2, FNP2, MCP2, FNE2, FNT2, FNC2, FND2, FNS1 - Codice segreto della carta non valido
    @Test
    void testInvalidCardSecretCode() throws Exception {
        String json = new Gson().toJson(Map.of(
                "username", "Giacomo Ricco",
                "email", "giacomo.ricco@gmail.com",
                "password", "Ciao12345@",
                "c_password", "Ciao12345@",
                "phone", "1234567890",
                "card_number", "2345897678367382",
                "card_expiry_date", "11/27",
                "card_secret_code", "2"
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        SignupController controller = new SignupController();
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Codice segreto della carta non valido");
    }

    // TC_VIS_11: LN2, FNN2, FNP2, MCP2, FNE2, FNT2, FNC2, FND2, FNS2, ME1 - L'email è già presente nel database
    @Test
    void testDuplicateEmail() throws Exception {
        try (MockedStatic<DatabaseConnection> mockedDB = mockStatic(DatabaseConnection.class)) {
            mockedDB.when(DatabaseConnection::getConnection).thenReturn(connection);
            String json = new Gson().toJson(Map.of(
                    "username", "Giacomo Ricco",
                    "email", "alice@example.com",
                    "password", "Ciao12345@",
                    "c_password", "Ciao12345@",
                    "phone", "1234567890",
                    "card_number", "2345897678367382",
                    "card_expiry_date", "11/27",
                    "card_secret_code", "234"
            ));
            test.log(Status.INFO, json);
//        User existingUser = new User("Giacomo Ricco", "alice@example.com", "Ciao12345@", "1234567890");
//        UserValidator.userList.add(existingUser); // Simuliamo che l'utente esista già nella lista

            //Simuliamo la richiesta
            when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

            //Simuliamo la response
            when(response.getWriter()).thenReturn(printWriter);

            //Simuliamo la risposta del database
            when(connection.prepareStatement(anyString(), eq(PreparedStatement.RETURN_GENERATED_KEYS))).thenReturn(statement);
            doNothing().when(statement).setString(anyInt(), anyString());
            when(statement.executeUpdate()).thenThrow(new SQLException("Duplicate key"));

            //Eseguiamo l'inserimento dell'utente
            SignupController controller = new SignupController();
            controller.doGet(request, response);

            //Verifichiamo cosa viene restituito dalla response
            verify(printWriter).println("error");
            test.pass("Test passato: Email già presente nel database");
        }
    }

    // TC_VIS_12: LN2, FNN2, LP2, FNP2, MCP2, FNE2, FNT2, FNC2, FND2, FNS2, ME2 - La registrazione va a buon fine
    @Test
    void testValidInput() throws Exception {
        try (MockedStatic<DatabaseConnection> mockedDB = mockStatic(DatabaseConnection.class)) {
            mockedDB.when(DatabaseConnection::getConnection).thenReturn(connection);
            String json = new Gson().toJson(Map.of(
                    "username", "Giacomo Ricco",
                    "email", "giacomo.ricco@gmail.comm",
                    "password", "Ciao12345@",
                    "c_password", "Ciao12345@",
                    "phone", "1234567890",
                    "card_number", "2345897678367382",
                    "card_expiry_date", "11/27",
                    "card_secret_code", "234"
            ));
            test.log(Status.INFO, json);
            //Simuliamo la richiesta
            when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));

            //Simuliamo la response
            when(response.getWriter()).thenReturn(printWriter);

            //Simuliamo la risposta del database
            when(connection.prepareStatement(anyString(), eq(PreparedStatement.RETURN_GENERATED_KEYS))).thenReturn(statement);
            when(connection.prepareStatement(anyString())).thenReturn(statement);
            doNothing().when(statement).setString(anyInt(), anyString());
            doNothing().when(statement).setInt(anyInt(), anyInt());
            //when(statement.executeUpdate()).thenReturn(1);
            when(statement.getGeneratedKeys()).thenReturn(resultSet);
            when(resultSet.next()).thenReturn(true);
            when(resultSet.getInt(anyInt())).thenReturn(1);

            //Simuliamo la sessione
            when(request.getSession(false)).thenReturn(session);
            when(request.getSession(true)).thenReturn(session);
            doNothing().when(session).invalidate();
            doNothing().when(session).setAttribute(anyString(), any());

            //Eseguiamo l'inserimento dell'utente
            SignupController controller = new SignupController();
            controller.doGet(request, response);

            //Verifichiamo cosa viene restituito dalla response
            verify(printWriter).println("users-nav-servlet?pg=homepage");
            System.out.println("La registrazione va a buon fine");
            test.pass("Test passato: La registrazione va a buon fine");
        }
    }

    @AfterAll
    static void tearDown() {
        extent.flush();
    }
}
