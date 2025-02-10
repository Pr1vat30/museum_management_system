package museum_management_system.Presentation.Controllers.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Facade.MessageFacade;

import java.io.IOException;

@WebServlet(name = "messageServlet", value = "/admin-message-servlet")
public class MessageController extends HttpServlet {

    private final MessageFacade messageFacade = new MessageFacade();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");

        String operation = request.getParameter("op");
        if (operation == null) {
            System.out.println("Invalid operation");
            return;
        }

        switch (operation) {
            case "insert_message":
                try{
                    messageFacade.insertMessage(request, response);
                    response.addHeader("success", "Message inserted successfully");
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    response.addHeader("error", e.getMessage());
                }
                break;
            case "update_message":
                try{
                    messageFacade.updateMessage(request, response);
                    response.addHeader("success", "Message updated successfully");
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    response.addHeader("error", e.getMessage());
                }
                break;
            case "delete_message":
                try{
                    messageFacade.deleteMessage(request, response);
                    response.addHeader("success", "Message deleted successfully");
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    response.addHeader("error", e.getMessage());
                }
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