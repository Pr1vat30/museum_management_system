package museum_management_system.Application.Service;

import museum_management_system.Storage.Dao.StoreDao;
import museum_management_system.Storage.Model.Purchase;
import museum_management_system.Storage.Model.StoreItem;

import java.util.List;
import java.util.Map;

public class StoreService {

    public List<StoreItem> getStore() {
        StoreDao storeDao = new StoreDao();
        return storeDao.GetStore();
    }

    public List<Purchase> getPurchase() {
        StoreDao storeDao = new StoreDao();
        return storeDao.GetPurchase();
    }

    public void save(Map<String, Object> jsonMap) {
        Purchase purchase = new Purchase(
                Integer.parseInt((String) jsonMap.get("user_id")),
                Integer.parseInt((String) jsonMap.get("ticket_id")),
                Integer.parseInt((String) jsonMap.get("event_id"))
        );
       StoreDao storeDao = new StoreDao();
       storeDao.InsertPurchase(purchase);
    }
}
