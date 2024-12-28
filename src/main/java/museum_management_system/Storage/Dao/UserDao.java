package museum_management_system.Storage.Dao;

import museum_management_system.Storage.Model.User;
import museum_management_system.Storage.Utils.DatabaseConnection;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class UserDao {

    private final Connection connection = DatabaseConnection.connection;

    public User SerchUser(String email, String password) {
        try {
            String sql = "SELECT * FROM User WHERE user_email = ? and user_password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            if ( resultSet.next() ){
                user = new User(resultSet.getInt("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_email"),
                        resultSet.getString("user_password"),
                        resultSet.getString("user_phone"));
            } else return null;
            resultSet.close(); statement.close();
            return user;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public User InsertUser(User user) {
        try {
            String sql = "INSERT INTO User (user_name, user_password, user_email, user_phone) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
            statement.executeUpdate();

            int user_id = 0;
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user_id = generatedKeys.getInt(1);
                    user.setUser_id(user_id);
                } else throw new SQLException("Creating user failed, no ID obtained.");
            }
            return user;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
