package museum_management_system.Presentation.Controllers.Staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Facade.EventFacade;

import java.io.IOException;

@WebServlet(name = "eventServlet", value = "/staff-event-servlet")
public class EventController extends HttpServlet {

    private final EventFacade eventFacade = new EventFacade();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String operation = request.getParameter("op");
        if (operation == null) {
            System.out.println("Invalid operation");
            return;
        }

        switch (operation) {
            case "insert_event":
                eventFacade.insertEvent(request, response);
                break;
            case "update_event":
                eventFacade.updateEvent(request, response);
                break;
            case "delete_event":
                eventFacade.deleteEvent(request, response);
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