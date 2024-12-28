package museum_management_system.Presentation.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Application.Service.AuthService;
import museum_management_system.Storage.Model.Admin;
import museum_management_system.Storage.Model.User;

import java.io.IOException;

@WebServlet(name = "authServlet", value = "/auth-servlet")
public class AuthController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        switch (request.getParameter("op")) {
            case "login": login(request, response); break;
            case "logout": logout(request, response); break;
            default: System.out.println("Invalid operation"); break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AuthService authService = new AuthService();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Object user = authService.login(email, password);

        if (user != null) {

            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setAttribute("logged", true);

            if( user instanceof User ) {
                response.getWriter().println("access-servlet?pg=homepage");
            } else if ( user instanceof Admin) {
                response.getWriter().println("admin-nav-servlet?pg=homepage");
            }

        } else response.getWriter().write("error");

    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);

        if (session != null)
            session.invalidate();

        RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
        dispatcher.forward(request, response);
    }
}