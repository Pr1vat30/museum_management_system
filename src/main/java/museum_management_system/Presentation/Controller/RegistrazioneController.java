package museum_management_system.Presentation.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Dto.UserDTO;
import museum_management_system.Application.Service.RegistrazioneService;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "registrazione", value = {"/registrazione"})
public class RegistrazioneController extends HttpServlet {
    public RegistrazioneController() {}

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/signup.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telefono = request.getParameter("telefono");
        UserDTO userDTO;
        try {
            userDTO = new UserDTO(nome, cognome, email, password, telefono);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        RegistrazioneService service = new RegistrazioneService();
        boolean success = service.saveUser(userDTO);

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
