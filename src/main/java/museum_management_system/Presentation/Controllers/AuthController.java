package museum_management_system.Presentation.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Facade.AuthFacade;

import java.io.IOException;

@WebServlet(name = "authServlet", value = "/auth-servlet")
public class AuthController extends HttpServlet {

    private final AuthFacade authFacade = new AuthFacade();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String operation = request.getParameter("op");
        if (operation == null) {
            System.out.println("Invalid operation");
            return;
        }

        switch (operation) {
            case "login":
                String loginResult = authFacade.handleLogin(request);
                response.getWriter().println(loginResult);
                break;
            case "logout":
                authFacade.handleLogout(request, response);
                break;
            default:
                System.out.println("Invalid operation");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}