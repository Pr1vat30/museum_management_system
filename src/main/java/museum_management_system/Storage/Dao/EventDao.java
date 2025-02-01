package museum_management_system.Storage.Dao;

import museum_management_system.Storage.Model.Art;
import museum_management_system.Storage.Model.Event;
import museum_management_system.Storage.Utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDao {

    private final Connection connection = DatabaseConnection.connection;

    public List<Event> GetEvents() {
        try {
            String sql = "SELECT * FROM Events";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Event> events = new ArrayList<>();
            if ( !resultSet.next() ){
                return null;
            } else do {
                Event event = new Event(resultSet.getInt("event_id"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date"),
                        resultSet.getInt("n_seats"),
                        resultSet.getInt("n_seats_available"),
                        resultSet.getString("event_desc"),
                        resultSet.getString("event_name")
                );
                events.add(event);
            } while (resultSet.next());
            resultSet.close();
            return events;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int insertEvent(Event event) {
        String sql = "INSERT INTO Events (start_date, end_date, n_seats, n_seats_available, event_desc, event_name) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, new java.sql.Date(event.getStart_date().getTime()));
            statement.setDate(2, new java.sql.Date(event.getEnd_date().getTime()));
            statement.setInt(3, event.getN_seats());
            statement.setInt(4, event.getN_seats_available());
            statement.setString(5, event.getName());
            statement.setString(6, event.getDesc());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating event failed, no ID obtained.");
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean UpdateEvent(Event event) {
        return true;
    }

    public boolean DeleteEvent(int event_id) {
        try {
            String sql = "DELETE FROM Events WHERE event_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, event_id);
            int result = statement.executeUpdate();
            statement.close();
            return result == 1;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
