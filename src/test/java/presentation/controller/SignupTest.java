package presentation.controller;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Application.Facade.SignupFacade;
import museum_management_system.Application.Service.SignupService;
import museum_management_system.Storage.Model.PayMethod;
import museum_management_system.Storage.Model.User;
import museum_management_system.Storage.Utils.DatabaseConnection;
import museum_management_system.Storage.Utils.UserValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SignupTest {
    private SignupFacade signupFacade;
    private HttpServletRequest request;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        signupFacade = new SignupFacade();
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        //DatabaseConnection.StartConnection();
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

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getSession(false)).thenReturn(null); // Nessuna sessione attuale
        when(request.getSession(true)).thenReturn(session); // Nuova sessione

        String result = signupFacade.handleSignup(request);
        assertEquals("error", result);
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

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getSession(false)).thenReturn(null); // Nessuna sessione attuale
        when(request.getSession(true)).thenReturn(session); // Nuova sessione

        String result = signupFacade.handleSignup(request);
        assertEquals("error", result);
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

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getSession(false)).thenReturn(null); // Nessuna sessione attuale
        when(request.getSession(true)).thenReturn(session); // Nuova sessione

        String result = signupFacade.handleSignup(request);
        assertEquals("error", result);
    }

    // TC_VIS_4: LN2, FNN2, LP1, FNP1. Lunghezza password non valida (meno di 6 caratteri)
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

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getSession(false)).thenReturn(null); // Nessuna sessione attuale
        when(request.getSession(true)).thenReturn(session); // Nuova sessione

        String result = signupFacade.handleSignup(request);
        assertEquals("error", result);
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

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getSession(false)).thenReturn(null); // Nessuna sessione attuale
        when(request.getSession(true)).thenReturn(session); // Nuova sessione

        String result = signupFacade.handleSignup(request);
        assertEquals("error", result);
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

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getSession(false)).thenReturn(null); // Nessuna sessione attuale
        when(request.getSession(true)).thenReturn(session); // Nuova sessione

        String result = signupFacade.handleSignup(request);
        assertEquals("error", result);
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

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getSession(false)).thenReturn(null); // Nessuna sessione attuale
        when(request.getSession(true)).thenReturn(session); // Nuova sessione

        String result = signupFacade.handleSignup(request);
        assertEquals("error", result);
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

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getSession(false)).thenReturn(null); // Nessuna sessione attuale
        when(request.getSession(true)).thenReturn(session); // Nuova sessione

        String result = signupFacade.handleSignup(request);
        assertEquals("error", result);
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

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getSession(false)).thenReturn(null); // Nessuna sessione attuale
        when(request.getSession(true)).thenReturn(session); // Nuova sessione

        String result = signupFacade.handleSignup(request);
        assertEquals("error", result);
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

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getSession(false)).thenReturn(null); // Nessuna sessione attuale
        when(request.getSession(true)).thenReturn(session); // Nuova sessione

        String result = signupFacade.handleSignup(request);
        assertEquals("error", result);
    }

    // TC_VIS_11: LN2, FNN2, FNP2, MCP2, FNE2, FNT2, FNC2, FND2, FNS2, ME1 - L'email è già presente nel database
    @Test
    void testDuplicateEmail() throws Exception {
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

        User existingUser = new User("Giacomo Ricco", "alice@example.com", "Ciao12345@", "1234567890");
        UserValidator.userList.add(existingUser); // Simuliamo che l'utente esista già nella lista

        // Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getSession(false)).thenReturn(null); // Nessuna sessione attuale
        when(request.getSession(true)).thenReturn(session); // Nuova sessione

        // Verifica che il risultato sia "error" quando l'email è duplicata
        String result = signupFacade.handleSignup(request);
        assertEquals("error", result);

        // Verifica che l'utente non venga aggiunto alla lista a causa dell'errore
        assertEquals(1, UserValidator.userList.size());
    }

    // TC_VIS_12: LN2, FNN2, LP2, FNP2, MCP2, FNE2, FNT2, FNC2, FND2, FNS2, ME2 - La registrazione va a buon fine
    @Test
    void testValidInput() throws Exception {

        SignupService signupService = mock(SignupService.class);
        signupFacade = new SignupFacade(signupService);

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

        User user_item = new User(
                "Giacomo Ricco",
                "giacomo.ricco@gmail.com",
                "Ciao12345@",
                "1234567890"
        );

        PayMethod payMethod = new PayMethod(
                "2345897678367382",
                "11/27",
                "234"
        );

        //Simuliamo la richiesta
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
        when(request.getSession(false)).thenReturn(null); // Nessuna sessione attuale
        when(request.getSession(true)).thenReturn(session); // Nuova sessione

        when(signupService.save(any(), any())).thenReturn(user_item);

        String result = signupFacade.handleSignup(request);
        assertEquals("users-nav-servlet?pg=homepage", result);
    }
}
