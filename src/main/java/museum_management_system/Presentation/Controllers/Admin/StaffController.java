package museum_management_system.Presentation.Controllers.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Facade.StaffFacade;

import java.io.IOException;

@WebServlet(name = "m-staffServlet", value = "/admin-staff-servlet")
public class StaffController extends HttpServlet {

    private final StaffFacade staffFacade = new StaffFacade();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String operation = request.getParameter("op");
        if (operation == null) {
            System.out.println("Invalid operation");
            return;
        }

        switch (operation) {
            case "insert_staff":
                staffFacade.insertStaff(request, response);
                break;
            case "update_staff":
                staffFacade.updateStaff(request, response);
                break;
            case "delete_staff":
                staffFacade.deleteStaff(request, response);
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