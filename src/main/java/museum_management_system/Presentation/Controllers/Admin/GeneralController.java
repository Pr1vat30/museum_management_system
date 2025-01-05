package museum_management_system.Presentation.Controllers.Admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Service.MessageService;

import java.io.IOException;

@WebServlet(name = "adminServlet", value = "/admin-nav-servlet")
public class GeneralController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        if (request.getParameter("pg") == null) {
            homepage(request, response);
        } else {
            switch (request.getParameter("pg")) {
                case "homepage":
                    homepage(request, response);
                    break;
                case "notification":
                    notification(request, response);
                    break;
                default:
                    System.out.println("Invalid page parameter");
                    break;
            }
        }
    }

    public void homepage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = "/WEB-INF/pages/admin_section/homepage.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    public void notification(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = "/WEB-INF/pages/admin_section/notification.jsp";

        MessageService messageService = new MessageService();
        request.setAttribute("messages", messageService.get());

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
