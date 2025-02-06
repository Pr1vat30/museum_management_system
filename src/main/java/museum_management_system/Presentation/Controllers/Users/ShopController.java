package museum_management_system.Presentation.Controllers.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Facade.ShopFacade;

import java.io.IOException;

@WebServlet(name = "shopServlet", value = "/users-shop-servlet")
public class ShopController extends HttpServlet {

    private final ShopFacade shopFacade = new ShopFacade();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String operation = request.getParameter("op");
        if (operation == null) {
            System.out.println("Invalid operation");
            return;
        }

        switch (operation) {
            case "insert_purchase":
                shopFacade.insertPurchase(request);
                response.getWriter().println("Purchase inserted successfully");
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