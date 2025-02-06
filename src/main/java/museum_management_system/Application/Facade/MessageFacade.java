package museum_management_system.Application.Facade;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Service.MessageService;
import museum_management_system.Storage.Model.Message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class MessageFacade {

    private final MessageService messageService;
    private final Gson gson;

    public MessageFacade() {
        this.messageService = new MessageService();
        this.gson = new Gson();
    }

    public void insertMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);
        Message message = new Message(
                (String) jsonMap.get("title"),
                (String) jsonMap.get("object"),
                (String) jsonMap.get("content")
        );
        List<Message> messages = messageService.save(message);
        sendResponse(response, messages);
    }

    public void updateMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);
        Message message = new Message(
                (String) jsonMap.get("title"),
                (String) jsonMap.get("object"),
                (String) jsonMap.get("content")
        );
        message.setMessage_id(Integer.parseInt((String) jsonMap.get("message_id")));
        List<Message> messages = messageService.update(message);
        sendResponse(response, messages);
    }

    public void deleteMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int messageId = Integer.parseInt(request.getParameter("id"));
        List<Message> messages = messageService.delete(messageId);
        sendResponse(response, messages);
    }

    private void sendResponse(HttpServletResponse response, List<Message> messages) throws IOException {
        String json = gson.toJson(messages);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }
}