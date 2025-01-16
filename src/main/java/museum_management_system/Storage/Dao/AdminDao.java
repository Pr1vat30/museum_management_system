package museum_management_system.Storage.Dao;

import museum_management_system.Storage.Model.Admin;
import museum_management_system.Storage.Utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {

    private final Connection connection = DatabaseConnection.connection;

    public Admin SerchAdmin(String email, String password) {
        try {
            String sql = "SELECT * FROM Admin WHERE admin_email = ? and admin_password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            Admin admin = null;
            if ( resultSet.next() ){
                admin = new Admin(resultSet.getInt("admin_id"),
                        resultSet.getString("admin_cf"),
                        resultSet.getString("admin_name"),
                        resultSet.getString("admin_surname"),
                        resultSet.getString("admin_email"),
                        resultSet.getString("admin_password"));
            } else return null;
            resultSet.close(); statement.close();
            return admin;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
