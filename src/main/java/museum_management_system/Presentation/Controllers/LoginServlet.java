package museum_management_system.Presentation.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        login(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MockDao dao = new MockDao();
        User user = dao.getUser(request.getParameter("email"), request.getParameter("password"));

        if (user != null) {

            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setAttribute("logged", true);

            if( user.getRole() ) {
                response.getWriter().println("auth-servlet?pg=admin");
            } else  {
                response.getWriter().println("auth-servlet?pg=home");
            }

        } else response.getWriter().write("error");
    }

    /* ---- Mock data for testing - delete when database is complete ---- */

    public static class MockDao {
        private final Map<String, String> mockUsers = new HashMap<>();

        public MockDao() {
            mockUsers.put("first.admin@example.com", "admin1");
            mockUsers.put("first.user@example.com", "user1");

            mockUsers.put("second.admin@example.com", "admin2");
            mockUsers.put("second.user@example.com", "user2");

            mockUsers.put("third.admin@example.com", "admin3");
            mockUsers.put("third.user@example.com", "user3");
        }

        public User getUser(String email, String password) {
            if (mockUsers.containsKey(email) && mockUsers.get(email).equals(password)) {
                boolean isAdmin = email.contains("admin");
                return new User(email, isAdmin);
            } else return null;
        }
    }

    public static class User {
        private final boolean role;
        private final String email;

        public User(String email, boolean role) {
            this.role = role;
            this.email = email;
        }

        public boolean getRole() { return role; }
    }

}