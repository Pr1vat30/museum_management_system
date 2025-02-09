package presentation.controller;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.gson.Gson;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import museum_management_system.Presentation.Controllers.SignupController;
import museum_management_system.Presentation.Controllers.Staff.ArtsController;
import museum_management_system.Storage.Dao.ArtsDao;
import museum_management_system.Storage.Model.Art;
import museum_management_system.Storage.Utils.DatabaseConnection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.MockedStatic;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

public class InsertArtTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private PrintWriter printWriter;
    private static ExtentReports extent;
    private ExtentTest test;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Part filePart;
    private byte[] fakeImageData;
    private InputStream inputStream;
    private  ServletConfig config;
    private ServletContext context;

    @BeforeAll
    static void setupExtent() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-reports/InsertArtTestReport.html");
        spark.config().setDocumentTitle("ArtsController Test Report");
        spark.config().setReportName("Test di ArtsController");
        spark.config().setTimelineEnabled(true);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Bucciero Vincenzo");
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
        filePart = mock(Part.class);

        fakeImageData = new byte[]{(byte) 0xFF, (byte) 0xD8, (byte) 0xFF}; // Simula un file JPEG
        inputStream = new ByteArrayInputStream(fakeImageData); // Simula inputstream per il file jpeg

        config = mock(ServletConfig.class);
        context = mock(ServletContext.class);
    }

    @Test
    void testInvalidName() throws Exception {
        String json = new Gson().toJson(Map.of(
                "name", "Giocondaxaxaxaxaxaxaxaxaxaxaaxaxaxxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxa",
                "desc", "Opera iconica ed enigmatica della pittura mondiale, " +
                        "si tratta sicuramente del ritratto più celebre della storia " +
                        "nonché di una delle opere d'arte più note in assoluto.",
                "artist", "Leonardo da Vinci",
                "lenght", "53",
                "height", "77"
        ));

        // Configuriamo il mock di Part
        when(filePart.getInputStream()).thenReturn(inputStream);
        when(filePart.getSubmittedFileName()).thenReturn("test-image.jpg");
        when(filePart.getSize()).thenReturn((long) fakeImageData.length);
        when(filePart.getContentType()).thenReturn("image/jpeg");

        test.log(Status.INFO, json);

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getParameter("op")).thenReturn("insert_art");

        // Configuriamo la richiesta per restituire il file come parte della richiesta
        when(request.getPart("cover")).thenReturn(filePart);

        //Impostare il context della servlet
        when(config.getServletContext()).thenReturn(context);
        when(context.getRealPath("")).thenReturn("C:/what/uploads");

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        ArtsController controller = new ArtsController();
        controller.init(config); // Inizializziamo il servlet
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Nome troppo lungo");
    }



    @Test
    void testInvalidDesc() throws Exception {
        String json = new Gson().toJson(Map.of(
                "name", "Gioconda",
                "desc", "Opera iconica ed enigmatica della pittura mondiale, si tratta sicuramente del ritratto " +
                        "più celebre della storia nonché di una delle opere d'arte più note in assoluto. Il sorriso quasi " +
                        "impercettibile del soggetto, col suo alone di mistero, ha ispirato tantissime pagine di critica, " +
                        "letteratura, opere di immaginazione e persino studi psicoanalitici sfuggente, ironica e sensuale, " +
                        "la Monna Lisa è stata di volta in volta amata e idolatrata, ma anche irrisa e vandalizzata",
                "artist", "Leonardo da Vinci",
                "lenght", "53",
                "height", "77"
        ));

        // Configuriamo il mock di Part
        when(filePart.getInputStream()).thenReturn(inputStream);
        when(filePart.getSubmittedFileName()).thenReturn("test-image.jpg");
        when(filePart.getSize()).thenReturn((long) fakeImageData.length);
        when(filePart.getContentType()).thenReturn("image/jpeg");

        test.log(Status.INFO, json);

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getParameter("op")).thenReturn("insert_art");

        // Configuriamo la richiesta per restituire il file come parte della richiesta
        when(request.getPart("cover")).thenReturn(filePart);

        //Impostare il context della servlet
        when(config.getServletContext()).thenReturn(context);
        when(context.getRealPath("")).thenReturn("C:/what/uploads");

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        ArtsController controller = new ArtsController();
        controller.init(config); // Inizializziamo il servlet
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Descrizione troppo lunga");
    }



    @Test
    void testInvalidArtist() throws Exception {
        String json = new Gson().toJson(Map.of(
                "name", "Gioconda",
                "desc", "Opera iconica ed enigmatica della pittura mondiale, " +
                        "si tratta sicuramente del ritratto più celebre della storia " +
                        "nonché di una delle opere d'arte più note in assoluto.",
                "artist", "Pablo Diego José Francisco de Paula Juan Nepomuceno " +
                        "Maria de los Remedios Cipriano de la Santísima Trinidad Ruiz y Picasso ",
                "lenght", "53",
                "height", "77"
        ));

        // Configuriamo il mock di Part
        when(filePart.getInputStream()).thenReturn(inputStream);
        when(filePart.getSubmittedFileName()).thenReturn("test-image.jpg");
        when(filePart.getSize()).thenReturn((long) fakeImageData.length);
        when(filePart.getContentType()).thenReturn("image/jpeg");

        test.log(Status.INFO, json);

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getParameter("op")).thenReturn("insert_art");

        // Configuriamo la richiesta per restituire il file come parte della richiesta
        when(request.getPart("cover")).thenReturn(filePart);

        //Impostare il context della servlet
        when(config.getServletContext()).thenReturn(context);
        when(context.getRealPath("")).thenReturn("C:/what/uploads");

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        ArtsController controller = new ArtsController();
        controller.init(config); // Inizializziamo il servlet
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Nome artista troppo lungo");
    }



    @Test
    void testInvalidLenght() throws Exception {
        String json = new Gson().toJson(Map.of(
                "name", "Gioconda",
                "desc", "Opera iconica ed enigmatica della pittura mondiale, " +
                        "si tratta sicuramente del ritratto più celebre della storia " +
                        "nonché di una delle opere d'arte più note in assoluto.",
                "artist", "Leonardo da Vinci",
                "lenght", "bella",
                "height", "77"
        ));

        // Configuriamo il mock di Part
        when(filePart.getInputStream()).thenReturn(inputStream);
        when(filePart.getSubmittedFileName()).thenReturn("test-image.jpg");
        when(filePart.getSize()).thenReturn((long) fakeImageData.length);
        when(filePart.getContentType()).thenReturn("image/jpeg");

        test.log(Status.INFO, json);

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getParameter("op")).thenReturn("insert_art");

        // Configuriamo la richiesta per restituire il file come parte della richiesta
        when(request.getPart("cover")).thenReturn(filePart);

        //Impostare il context della servlet
        when(config.getServletContext()).thenReturn(context);
        when(context.getRealPath("")).thenReturn("C:/what/uploads");

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        ArtsController controller = new ArtsController();
        controller.init(config); // Inizializziamo il servlet
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Lunghezza formato incorretto");
    }



    @Test
    void testInvalidHeight() throws Exception {
        String json = new Gson().toJson(Map.of(
                "name", "Gioconda",
                "desc", "Opera iconica ed enigmatica della pittura mondiale, " +
                        "si tratta sicuramente del ritratto più celebre della storia " +
                        "nonché di una delle opere d'arte più note in assoluto.",
                "artist", "Leonardo da Vinci",
                "lenght", "53",
                "height", "bella"
        ));

        // Configuriamo il mock di Part
        when(filePart.getInputStream()).thenReturn(inputStream);
        when(filePart.getSubmittedFileName()).thenReturn("test-image.jpg");
        when(filePart.getSize()).thenReturn((long) fakeImageData.length);
        when(filePart.getContentType()).thenReturn("image/jpeg");

        test.log(Status.INFO, json);

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getParameter("op")).thenReturn("insert_art");

        // Configuriamo la richiesta per restituire il file come parte della richiesta
        when(request.getPart("cover")).thenReturn(filePart);

        //Impostare il context della servlet
        when(config.getServletContext()).thenReturn(context);
        when(context.getRealPath("")).thenReturn("C:/what/uploads");

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);

        //Eseguiamo l'inserimento dell'utente
        ArtsController controller = new ArtsController();
        controller.init(config); // Inizializziamo il servlet
        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("error");
        test.pass("Test passato: Altezza formato incorretto");
    }



    @Test
    void testValidInput() throws Exception {

        try(MockedStatic<DatabaseConnection> mockedDB = mockStatic(DatabaseConnection.class)){
            mockedDB.when(DatabaseConnection::getConnection).thenReturn(connection);



        String json = new Gson().toJson(Map.of(
                "name", "Gioconda",
                "desc", "Opera iconica ed enigmatica della pittura mondiale, " +
                        "si tratta sicuramente del ritratto più celebre della storia " +
                        "nonché di una delle opere d'arte più note in assoluto.",
                "artist", "Leonardo da Vinci",
                "lenght", "53",
                "height", "77"
        ));

        // Configuriamo il mock di Part
        when(filePart.getInputStream()).thenReturn(inputStream);
        when(filePart.getSubmittedFileName()).thenReturn("test-image.jpg");
        when(filePart.getSize()).thenReturn((long) fakeImageData.length);
        when(filePart.getContentType()).thenReturn("image/jpeg");

        test.log(Status.INFO, json);

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getParameter("op")).thenReturn("insert_art");

        // Configuriamo la richiesta per restituire il file come parte della richiesta
        when(request.getPart("cover")).thenReturn(filePart);

        //Impostare il context della servlet
        when(config.getServletContext()).thenReturn(context);
        when(context.getRealPath("")).thenReturn("C:/what/uploads");

        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);


        //Simuliamo la risposta del database
        when(connection.prepareStatement(anyString(), eq(PreparedStatement.RETURN_GENERATED_KEYS))).thenReturn(statement);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        doNothing().when(statement).setString(anyInt(), anyString());
        doNothing().when(statement).setInt(anyInt(), anyInt());
        //when(statement.executeUpdate()).thenReturn(1);
        when(statement.executeQuery()).thenReturn(resultSet);
        when(statement.getGeneratedKeys()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(false);




        //Eseguiamo l'inserimento dell'utente
        ArtsController controller = new ArtsController();
        controller.init(config); // Inizializziamo il servlet

        controller.doGet(request, response);

        //Verifichiamo cosa viene restituito dalla response
        verify(printWriter).println("ok");
        test.pass("Test passato: Tutti gli input validi");
        }
    }
}
