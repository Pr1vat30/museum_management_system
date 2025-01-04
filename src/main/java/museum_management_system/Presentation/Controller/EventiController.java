package museum_management_system.Presentation.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Dto.EventDTO;
import museum_management_system.Application.Service.GestioneEventi_MostreService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "mainEvents", value = "/mainevents")
public class EventiController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EventDTO> eventi = GestioneEventi_MostreService.getEventi();
        req.setAttribute("eventi", eventi);
        req.getRequestDispatcher("WEB-INF/pages/eventsMain.jsp").forward(req, resp);
    }
}
