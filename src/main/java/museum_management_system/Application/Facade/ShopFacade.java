package museum_management_system.Application.Facade;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Application.Service.AuthService;
import museum_management_system.Application.Service.ShopService;

import java.io.IOException;
import java.util.Map;
import jakarta.servlet.http.HttpServletRequest;
import museum_management_system.Storage.Model.Purchase;
import museum_management_system.Storage.Model.User;

public class ShopFacade {

    private final ShopService shopService;
    private final Gson gson;

    public ShopFacade() {
        this.shopService = new ShopService();
        this.gson = new Gson();
    }

    public boolean insertPurchase(HttpServletRequest request) throws IOException {
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);

        HttpSession session = request.getSession(false);
        String mail = ((User) session.getAttribute("user")).getEmail();
        String password = (String) jsonMap.get("user_password");

        AuthService authService = new AuthService();
        Object user = authService.login(mail, password);

        if(user != null){
            Purchase purchase = new Purchase(
                    Integer.parseInt((String) jsonMap.get("user_id")),
                    Integer.parseInt((String) jsonMap.get("ticket_id")),
                    Integer.parseInt((String) jsonMap.get("event_id"))
            );
            shopService.save(purchase);
            return true;
        }

        return false;
    }
}