package museum_management_system.Presentation.Controllers.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Service.ArtsService;
import museum_management_system.Application.Service.EventService;
import museum_management_system.Application.Service.MessageService;
import museum_management_system.Application.Service.ShopService;

import java.io.IOException;

@WebServlet(name = "usersServlet", value = "/users-nav-servlet")
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
                case "event":
                    event(request, response);
                    break;
                case "art":
                    art(request, response);
                    break;
                case "shop":
                    shop(request, response);
                    break;
                case "history":
                    history(request, response);
                    break;
                default:
                    System.out.println("Invalid page parameter");
                    break;
            }
        }
    }

    public void homepage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = "/WEB-INF/pages/users_section/homepage.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    public void notification(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = "/WEB-INF/pages/users_section/notification.jsp";

        MessageService messageService = new MessageService();
        request.setAttribute("messages", messageService.get());

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    public void event(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = "/WEB-INF/pages/users_section/event.jsp";

        EventService eventService = new EventService();
        request.setAttribute("events", eventService.get());

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    public void art(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = "/WEB-INF/pages/users_section/art.jsp";

        ArtsService artsService = new ArtsService();
        request.setAttribute("arts", artsService.get());

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    public void shop(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = "/WEB-INF/pages/users_section/shop.jsp";

        ShopService shopService = new ShopService();
        request.setAttribute("shop_items", shopService.getStore());

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    public void history(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = "/WEB-INF/pages/users_section/ticketHistory.jsp";

        ShopService shopService = new ShopService();
        request.setAttribute("purchases", shopService.getPurchase());

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

}
