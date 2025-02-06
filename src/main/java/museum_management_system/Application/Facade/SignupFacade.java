package museum_management_system.Application.Facade;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Application.Service.SignupService;
import museum_management_system.Storage.Model.User;

import java.io.IOException;
import java.util.Map;

public class SignupFacade {

    private final SignupService signupService;

    public SignupFacade() {
        this.signupService = new SignupService();
    }

    public String handleSignup(HttpServletRequest request) throws IOException {
        Gson gson = new Gson();
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);

        User user = signupService.save(jsonMap);

        if (user != null) {
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setAttribute("logged", true);

            return "users-nav-servlet?pg=homepage";
        }
        return "error";
    }
}