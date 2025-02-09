package museum_management_system.Storage.Dao;

import museum_management_system.Storage.Model.Message;
import museum_management_system.Storage.Utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {

    private final Connection connection = DatabaseConnection.getConnection();

    public List<Message> GetMessages() {
        try {
            String sql = "SELECT * FROM Message";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Message> messages = new ArrayList<>();
            if (!resultSet.next() ){
                return null;
            }else do {
                Message message = new Message(resultSet.getInt("message_id"),
                        resultSet.getString("message_title"),
                        resultSet.getString("message_object"),
                        resultSet.getString("message_content"),
                        resultSet.getDate("send_date").toString()
                );
                messages.add(message);
            } while (resultSet.next());
            resultSet.close();
            return messages;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void InsertMessage(Message message) {
        try {
            String sql = "INSERT INTO Message (message_title, message_object, message_content, send_date) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, message.getTitle());
            statement.setString(2, message.getObject());
            statement.setString(3, message.getContent());
            statement.setDate(4, new Date(System.currentTimeMillis()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean UpdateMessage(Message message) {
        try {
            String sql = "UPDATE Message SET message_title = ?, message_object = ?, message_content = ?, send_date = ? WHERE message_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, message.getTitle());
            statement.setString(2, message.getObject());
            statement.setString(3, message.getContent());
            statement.setDate(4, new Date(System.currentTimeMillis()));
            statement.setInt(5, message.getMessage_id());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean DeleteMessage(int message_id) {
        try {
            String sql = "DELETE FROM Message WHERE message_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, message_id);
            int result = statement.executeUpdate();
            statement.close();
            return result == 1;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


}
