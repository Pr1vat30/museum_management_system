package museum_management_system.Application.Facade;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Service.EventService;
import museum_management_system.Storage.Model.Event;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TicketFacade {

    private final EventService eventService;
    private final Gson gson;

    public TicketFacade() {
        this.eventService = new EventService();
        this.gson = new Gson();
    }

    public void insertEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int eventId = Integer.parseInt(request.getParameter("id"));
        List<Event> events = eventService.delete(eventId); // Probabile errore nella logica qui: verifica l'operazione corretta
        sendResponse(response, events);
    }

    public void updateEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int eventId = Integer.parseInt(request.getParameter("id"));
        List<Event> events = eventService.delete(eventId);
        sendResponse(response, events);
    }

    public void deleteEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int eventId = Integer.parseInt(request.getParameter("id"));
        List<Event> events = eventService.delete(eventId);
        sendResponse(response, events);
    }

    private void sendResponse(HttpServletResponse response, List<Event> events) throws IOException {
        String json = gson.toJson(events);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }
}