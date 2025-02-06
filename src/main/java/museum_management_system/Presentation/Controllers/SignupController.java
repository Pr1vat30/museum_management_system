package museum_management_system.Presentation.Controllers;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Application.Service.AuthService;
import museum_management_system.Application.Service.SignupService;
import museum_management_system.Storage.Model.User;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "signupServlet", value = "/signup-servlet")
public class SignupController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        signup(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);

        SignupService signupService = new SignupService();
        User user = signupService.save(jsonMap);

        if ( user != null ) {

            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setAttribute("logged", true);

            response.getWriter().println("users-nav-servlet?pg=homepage");

        } else response.getWriter().write("error");
    }
}
