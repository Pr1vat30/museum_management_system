package museum_management_system.Presentation.Controllers.Staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Facade.TicketFacade;

import java.io.IOException;

@WebServlet(name = "ticketServlet", value = "/staff-ticket-servlet")
public class TicketController extends HttpServlet {

    private final TicketFacade ticketFacade = new TicketFacade();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String operation = request.getParameter("op");
        if (operation == null) {
            System.out.println("Invalid operation");
            return;
        }

        switch (operation) {
            case "insert_ticket":
                ticketFacade.insertEvent(request, response);
                break;
            case "update_ticket":
                ticketFacade.updateEvent(request, response);
                break;
            case "delete_ticket":
                ticketFacade.deleteEvent(request, response);
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