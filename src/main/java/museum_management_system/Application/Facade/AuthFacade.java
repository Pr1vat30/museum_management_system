package museum_management_system.Application.Facade;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Application.Service.AuthService;
import museum_management_system.Storage.Model.Admin;
import museum_management_system.Storage.Model.Staff;
import museum_management_system.Storage.Model.User;

import java.io.IOException;
import java.util.Optional;

public class AuthFacade {

    private final AuthService authService;

    public AuthFacade() {
        this.authService = new AuthService();
    }

    public String handleLogin(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Object user = authService.login(email, password);

        if (user != null) {
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setAttribute("logged", true);

            if (user instanceof User) {
                return "users-nav-servlet?pg=homepage";
            } else if (user instanceof Admin) {
                return "admin-nav-servlet?pg=homepage";
            } else if (user instanceof Staff) {
                return "staff-nav-servlet?pg=homepage";
            }
        }
        return "error";
    }

    public void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Optional.ofNullable(request.getSession(false)).ifPresent(HttpSession::invalidate);

        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.getWriter().write("Logout Error");
        }
    }
}