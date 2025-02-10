package museum_management_system.Storage.Dao;

import museum_management_system.Storage.Model.Purchase;
import museum_management_system.Storage.Model.StoreItem;
import museum_management_system.Storage.Utils.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StoreDao {

    private Connection connection;

    public StoreDao() {
        this.connection = DatabaseConnection.getConnection();
    }

    public List<StoreItem> GetStore() {
        try {
            String sql = "SELECT * FROM TicketEventView";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<StoreItem> store = new ArrayList<>();
            if ( !resultSet.next() ){
                return null;
            } else do {
                StoreItem item = new StoreItem(resultSet.getInt("event_id"),
                        resultSet.getString("event_name"),
                        resultSet.getInt("ticket_id"),
                        resultSet.getString("ticket_type"),
                        resultSet.getDouble("ticket_price"),
                        resultSet.getInt("n_seats_available")
                );
                store.add(item);
            } while (resultSet.next());
            resultSet.close();
            return store;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Purchase> GetPurchase() {
        try {
            String sql = "SELECT * FROM TicketEventPurchaseView";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Purchase> purchases = new ArrayList<>();

            if (!resultSet.next()) {
                return null;
            } else {
                do {
                    // Crea un oggetto StoreItem con tutti i campi
                    Purchase purchase = new Purchase(
                            resultSet.getString("event_name"),
                            resultSet.getString("ticket_type"),
                            resultSet.getDouble("ticket_price"),
                            resultSet.getDate("purchase_date")
                    );
                    purchases.add(purchase);
                } while (resultSet.next());
            }

            resultSet.close();
            return purchases;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void InsertPurchase(Purchase purchase) {
        try {
            String sql = "INSERT INTO Purchases (purchase_date, ticket_id, event_id, user_id ) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, Date.valueOf(LocalDate.now()));
            statement.setInt(2, purchase.getTicket_id());
            statement.setInt(3, purchase.getEvent_id());
            statement.setInt(4, purchase.getUser_id());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
