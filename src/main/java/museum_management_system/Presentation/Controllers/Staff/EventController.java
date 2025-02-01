package museum_management_system.Presentation.Controllers.Staff;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Service.EventService;
import museum_management_system.Storage.Model.Event;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "eventServlet", value = "/staff-event-servlet")
public class EventController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        switch (request.getParameter("op")) {
            case "insert_event": insertEvent(request, response); break;
            case "update_event": updateEvent(request, response); break;
            case "delete_event": deleteEvent(request, response); break;
            default: System.out.println("Invalid operation"); break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void updateEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);

        EventService eventService = new EventService();
        List<Event> events = eventService.update(jsonMap);

        String json = gson.toJson(events);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }

    private void insertEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);

        EventService eventService = new EventService();
        List<Event> events = eventService.save(jsonMap);

        String json = gson.toJson(events);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }

    private void deleteEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int event_id = Integer.parseInt(request.getParameter("id"));
        Gson gson = new Gson();

        EventService eventService = new EventService();
        List<Event> events = eventService.delete(event_id);

        String json = gson.toJson(events);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }

}
