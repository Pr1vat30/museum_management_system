package museum_management_system.Presentation.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Application.Service.LoginService;
import museum_management_system.Application.Service.LogoutService;

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
        LoginService loginService = new LoginService();
        loginService.login(request, response);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LogoutService logoutService = new LogoutService();
        logoutService.logout(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
        dispatcher.forward(request, response);
    }
}