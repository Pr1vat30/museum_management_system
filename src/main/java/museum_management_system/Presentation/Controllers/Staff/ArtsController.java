package museum_management_system.Presentation.Controllers.Staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Facade.ArtsFacade;

import java.io.IOException;

@WebServlet(name = "artsServlet", value = "/staff-art-servlet")
@MultipartConfig
public class ArtsController extends HttpServlet {

    private final ArtsFacade artsFacade = new ArtsFacade();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String operation = request.getParameter("op");
        if (operation == null) {
            System.out.println("Invalid operation");
            return;
        }

        switch (operation) {
            case "insert_art":
                artsFacade.insertArt(getServletContext().getRealPath(""), request, response);
                break;
            case "update_art":
                artsFacade.updateArt(getServletContext().getRealPath(""), request, response);
                break;
            case "delete_art":
                artsFacade.deleteArt(request, response);
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