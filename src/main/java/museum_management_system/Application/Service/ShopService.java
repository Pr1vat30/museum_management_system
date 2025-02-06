package museum_management_system.Application.Service;

import museum_management_system.Storage.Dao.StoreDao;
import museum_management_system.Storage.Model.Purchase;
import museum_management_system.Storage.Model.StoreItem;

import java.util.List;

public class ShopService {

    public List<StoreItem> getStore() {
        StoreDao storeDao = new StoreDao();
        return storeDao.GetStore();
    }

    public List<Purchase> getPurchase() {
        StoreDao storeDao = new StoreDao();
        return storeDao.GetPurchase();
    }

    public void save(Purchase purchase) {
        StoreDao storeDao = new StoreDao();
        storeDao.InsertPurchase(purchase);
    }
}
