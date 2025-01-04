package museum_management_system.Presentation.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Dto.EventDTO;
import museum_management_system.Application.Service.GestioneEventi_MostreService;

import java.io.IOException;

@WebServlet(name = "EventPage", value = "/eventpage")
public class EventPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int eventId = Integer.parseInt(req.getParameter("id"));
        EventDTO event = GestioneEventi_MostreService.getEventById(eventId);
        req.setAttribute("event", event);
        req.getRequestDispatcher("WEB-INF/pages/eventpage.jsp").forward(req, resp);
    }
}
