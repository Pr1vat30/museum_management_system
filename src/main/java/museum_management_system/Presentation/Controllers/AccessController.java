package museum_management_system.Presentation.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(name = "accessServlet", value = "/access-servlet")
public class AccessController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        if (request.getParameter("pg") == null) {
            homepage(request, response);
        } else {
            switch (request.getParameter("pg")) {
                case "homepage":
                    homepage(request, response);
                    break;
                case "login":
                    login(request, response);
                    break;
                case "signup":
                    signup(request, response);
                    break;
                default:
                    System.out.println("Invalid page parameter");
                    break;
            }
        }
    }

    public void homepage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = "/index.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = "/WEB-INF/pages/login.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = "/WEB-INF/pages/signup.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}