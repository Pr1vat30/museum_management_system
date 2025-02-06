package museum_management_system.Application.Facade;

import com.google.gson.Gson;
import museum_management_system.Application.Service.StoreService;

import java.io.IOException;
import java.util.Map;
import jakarta.servlet.http.HttpServletRequest;

public class ShopFacade {

    private final StoreService storeService;
    private final Gson gson;

    public ShopFacade() {
        this.storeService = new StoreService();
        this.gson = new Gson();
    }

    public void insertPurchase(HttpServletRequest request) throws IOException {
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);
        storeService.save(jsonMap);
    }
}