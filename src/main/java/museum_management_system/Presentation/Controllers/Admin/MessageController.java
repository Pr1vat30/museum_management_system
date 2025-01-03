package museum_management_system.Presentation.Controllers.Admin;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Service.MessageService;
import museum_management_system.Storage.Model.Message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "messageServlet", value = "/admin-message-servlet")
public class MessageController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        switch (request.getParameter("op")) {
            case "insert_message": insertMessage(request, response); break;
            case "update_message": updateMessage(request, response); break;
            case "delete_message": deleteMessage(request, response); break;
            default: System.out.println("Invalid operation"); break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void insertMessage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Gson gson = new Gson();
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);

        MessageService messageService = new MessageService();
        List<Message> messages = messageService.save(jsonMap);

        String json = gson.toJson(messages);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }

    public void updateMessage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Gson gson = new Gson();
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);

        System.out.println(jsonMap.toString());

        MessageService messageService = new MessageService();
        List<Message> messages = messageService.update(jsonMap);

        String json = gson.toJson(messages);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }

    public void deleteMessage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int message_id = Integer.parseInt(request.getParameter("id"));
        Gson gson = new Gson();

        MessageService messageService = new MessageService();
        List<Message> messages = messageService.delete(message_id);

        String json = gson.toJson(messages);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }



}
