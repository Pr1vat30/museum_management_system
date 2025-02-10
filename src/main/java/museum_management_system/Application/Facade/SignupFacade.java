package museum_management_system.Application.Facade;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Application.Service.SignupService;
import museum_management_system.Storage.Model.PayMethod;
import museum_management_system.Storage.Model.User;
import museum_management_system.Storage.Utils.Validators.UserValidator;

import java.io.IOException;
import java.util.Map;

public class SignupFacade {

    private final SignupService signupService;

    public SignupFacade(SignupService signupService) {
        this.signupService = signupService;
    }

    public SignupFacade() {
        this.signupService = new SignupService();
    }

    public String handleSignup(HttpServletRequest request) throws IOException {
        Gson gson = new Gson();
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);

        if(jsonMap.get("password").equals(jsonMap.get("c_password"))){
            try {
                // Creazione degli oggetti user e payMethod
                User user_item = new User(
                        (String) jsonMap.get("username"),
                        (String) jsonMap.get("email"),
                        (String) jsonMap.get("password"),
                        (String) jsonMap.get("phone")
                );

                PayMethod payMethod = new PayMethod(
                        (String) jsonMap.get("card_number"),
                        (String) jsonMap.get("card_expiry_date"),
                        (String) jsonMap.get("card_secret_code")
                );

                // Validazione degli oggetti tramite il Validator
                UserValidator.validateUser(user_item);
                UserValidator.validatePaymentMethod(payMethod);

                User user = signupService.save(user_item, payMethod);

                if (user != null) {
                    HttpSession oldSession = request.getSession(false);
                    if (oldSession != null) {
                        oldSession.invalidate();
                    }

                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", user);
                    session.setAttribute("logged", true);

                    return "users-nav-servlet?pg=homepage";
                } else{
                    return "error";
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Errore di validazione: " + e.getMessage());
                return "error";
            }
        }
        return "error";
    }
}