package museum_management_system.Storage.Dao;

import museum_management_system.Storage.Model.Event;
import museum_management_system.Storage.Model.Message;
import museum_management_system.Storage.Model.Ticket;
import museum_management_system.Storage.Utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {

    private final Connection connection = DatabaseConnection.connection;

    public List<Ticket> GetTickets() {
        try {
            String sql = "SELECT * FROM Tickets";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            if ( !resultSet.next() ){
                return null;
            } else do {
                Ticket ticket = new Ticket(resultSet.getInt("ticket_id"),
                        resultSet.getString("ticket_type"),
                        resultSet.getDouble("ticket_price"),
                        resultSet.getInt("event_id")
                );
                tickets.add(ticket);
            } while (resultSet.next());
            resultSet.close();
            return tickets;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void InsertTicket(Ticket ticket) {
        try {
            String sql = "INSERT INTO Tickets (ticket_type, ticket_price, event_id) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ticket.getType());
            statement.setDouble(2, ticket.getPrice());
            statement.setInt(3, ticket.getEvent_id());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
