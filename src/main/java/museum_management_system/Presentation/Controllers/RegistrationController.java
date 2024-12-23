package museum_management_system.Presentation.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Storage.Model.User;
import museum_management_system.Application.Service.RegistrazioneService;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "registrazione", value = {"/registrazione"})
public class RegistrationController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        registration(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private static void registration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telefono = request.getParameter("telefono");
        User user;
        try {
            user = new User(nome, cognome, email, password, telefono);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        RegistrazioneService service = new RegistrazioneService();
        boolean success = service.saveUser(user);

        if(success) {
            //VADO ALLA PAGINA DI LOGIN
            //request.getRequestDispatcher("WEB-INF/pages/userProfile.jsp").forward(request, response);
        }
        else {
            //SE CI SONO ERRORI LANCIO LA PAGINA DI ERRORE
            request.getRequestDispatcher("WEB-INF/errors/erroreRegistrazione.jsp").forward(request, response);
        }
    }
}
