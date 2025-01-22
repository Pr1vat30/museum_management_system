package museum_management_system.Presentation.Controllers.Users;

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

@WebServlet(name = "shopServlet", value = "/users-shop-servlet")
public class ShopController extends HttpServlet {

}