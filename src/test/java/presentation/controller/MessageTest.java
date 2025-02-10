package presentation.controller;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Presentation.Controllers.Admin.MessageController;
import museum_management_system.Storage.Utils.DatabaseConnection;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import static org.mockito.Mockito.*;

public class MessageTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter printWriter;
    private static ExtentReports extent;
    private ExtentTest test;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    @BeforeAll
    static void setupExtent() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-reports/MessageTestReport.html");
        spark.config().setDocumentTitle("MessageController Test Report");
        spark.config().setReportName("Test di MessageController");
        spark.config().setTimelineEnabled(true);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Nocera Salvatore");
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
        test = extent.createTest(testinfo.getDisplayName());
    }

    //TC_AD_1: LT1 - Il titolo supera la lunghezza limite
    @Test
    void invalidTitle() throws Exception {
        String json = new Gson().toJson(Map.of(
                "title", "Nulla dignissim velit vitae ligula eleifend tristique. Proin bibendum a dolor non lacinia. Ut ultrices vitae velit at convallis. Quisque laoreet tincidunt tristique. Maecenas convallis ligula fermentum augue tincidunt feugiat. Maecenas eget diam rhoncus, condimentum sapien ac, porta nulla. Integer fermentum purus neque, eget auctor lacus sagittis in. Aenean ut risus.",
                "object", "Amministrazione ordinaria.",
                "content","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lorem dui, efficitur a magna eu, facilisis ultrices turpis. Donec suscipit lobortis risus, ut eleifend nulla."
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getParameter("op")).thenReturn("insert_message");
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);
        //Simuliamo il printwriter
        doNothing().when(printWriter).print(json);
        doNothing().when(printWriter).flush();

        //Eseguiamo l'inserimento dell'avviso
        MessageController msg = new MessageController();
        msg.doGet(request, response);
        verify(response).addHeader("error", "Titolo non valido o troppo lungo");
        test.pass("Il titolo supera la lunghezza limite");
    }

    //TC_AD_2: LT2, LO1 - L’oggetto supera la lunghezza limite
    @Test
    void invalidObject() throws Exception {
        String json = new Gson().toJson(Map.of(
                "title", "Predisposizione nuove misure di sicurezza.",
                "object", "Amministrazione ordinaria. Xaxaxaxaxaxaxaxaxaxaxaxaxaxaxaaxaxaaxaxax\n" +
                        "Xaxaxaxaxaxaxaxaxaxaxaxaxaxaxaaxaxaaxaxax\n" +
                        "Xaxaxaxaxaxaxaxaxaxaxaxaxaxaxaaxaxaaxaxax\n" +
                        "Xaxaxaxaxaxaxaxaxaxaxaxaxaxaxaaxaxaaxaxax\n",
                "content","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lorem dui, efficitur a magna eu, facilisis ultrices turpis. Donec suscipit lobortis risus, ut eleifend nulla."
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getParameter("op")).thenReturn("insert_message");
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);
        //Simuliamo il printwriter
        doNothing().when(printWriter).print(json);
        doNothing().when(printWriter).flush();

        //Eseguiamo l'inserimento dell'avviso
        MessageController msg = new MessageController();
        msg.doGet(request, response);
        verify(response).addHeader("error", "Oggetto non valido o troppo lungo");
        test.pass("L’oggetto supera la lunghezza limite");
    }

    //TC_AD_3: LT2, LO2, LC1 - Il contenuto supera la lunghezza limite
    @Test
    void invalidContent() throws Exception {
        String json = new Gson().toJson(Map.of(
                "title", "Predisposizione nuove misure di sicurezza.",
                "object", "Amministrazione ordinaria.",
                "content","Nel cuore della città, tra grattacieli che sfiorano il cielo e strade brulicanti di vita, si nasconde un mondo parallelo. Vicoli stretti e tortuosi, dove il tempo sembra essersi fermato, custodiscono storie dimenticate. Mura antiche, segnate dal passare dei secoli, raccontano di epoche lontane, di battaglie combattute e di amori perduti. Ogni angolo è un tesoro, ogni pietra un ricordo. Qui, il passato e il presente si intrecciano in un abbraccio silenzioso, creando un'atmosfera unica, sospesa tra realtà e memoria. Camminando tra queste strade, si respira l'essenza della storia, si sente il peso delle generazioni che ci hanno preceduto. È un luogo magico, dove il tempo non è più un confine, ma un ponte tra mondi diversi. E in questo labirinto di emozioni, ogni passo è una scoperta, ogni sguardo una rivelazione. La città, con le sue contraddizioni e bellezze, diventa un rifugio per l'anima, un luogo dove perdersi per ritrovarsi. E mentre il sole tramonta, tingendo il cielo di sfumature dorate, tutto sembra possibile, in questo angolo di mondo dove il tempo si ferma e la vita scorre lenta, come un fiume che attraversa il cuore della storia."
        ));
        test.log(Status.INFO, json);
        //Simuliamo la richiesta
        when(request.getParameter("op")).thenReturn("insert_message");
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        //Simuliamo la response
        when(response.getWriter()).thenReturn(printWriter);
        //Simuliamo il printwriter
        doNothing().when(printWriter).print(json);
        doNothing().when(printWriter).flush();

        //Eseguiamo l'inserimento dell'avviso
        MessageController msg = new MessageController();
        msg.doGet(request, response);
        verify(response).addHeader("error", "Contenuto troppo lungo");
        test.pass("Il contenuto supera la lunghezza limite");
    }

    //TC_AD_4: LT2, LO2, LC2 - L’aggiunta va a buon fine
    @Test
    void validMessage() throws Exception {
        try (MockedStatic<DatabaseConnection> mockedDB = mockStatic(DatabaseConnection.class)) {
            mockedDB.when(DatabaseConnection::getConnection).thenReturn(connection);
            String json = new Gson().toJson(Map.of(
                    "title", "Predisposizione nuove misure di sicurezza.",
                    "object", "Amministrazione ordinaria.",
                    "content","Nel cuore della foresta, tra alberi secolari e ruscelli cristallini, il tempo sembra fermarsi. Foglie danzano al vento, uccelli intonano melodie antiche, mentre la luce filtra tra i rami, creando mosaici di ombre e colori. Un respiro profondo, e l'armonia della natura avvolge ogni senso."
            ));
            test.log(Status.INFO, json);
            //Simuliamo la richiesta
            when(request.getParameter("op")).thenReturn("insert_message");
            when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
            //Simuliamo la response
            when(response.getWriter()).thenReturn(printWriter);
            //Simuliamo il printwriter
            doNothing().when(printWriter).print(json);
            doNothing().when(printWriter).flush();
            //Simuliamo il comportamento del database
            when(connection.prepareStatement(anyString())).thenReturn(statement);
            doNothing().when(statement).setString(anyInt(), anyString());
            doNothing().when(statement).setDate(anyInt(), any());
            when(statement.executeQuery()).thenReturn(resultSet);
            when(resultSet.next()).thenReturn(false);

            //Eseguiamo l'inserimento dell'avviso
            MessageController msg = new MessageController();
            msg.doGet(request, response);

            verify(response).addHeader("success", "Message inserted successfully");
            test.pass("Inserimento andato a buon fine");
        }
    }

    @AfterAll
    static void tearDown() {
        extent.flush();
    }
}
