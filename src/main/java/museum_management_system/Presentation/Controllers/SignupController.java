package museum_management_system.Presentation.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Facade.SignupFacade;

import java.io.IOException;

@WebServlet(name = "signupServlet", value = "/signup-servlet")
public class SignupController extends HttpServlet {

    private final SignupFacade signupFacade = new SignupFacade();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String result = signupFacade.handleSignup(request);
        response.getWriter().println(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}