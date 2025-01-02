package museum_management_system.Storage.Dao;

import museum_management_system.Storage.Model.DatabaseConnection;
import museum_management_system.Storage.Model.Ticket;

import java.sql.Connection;
import java.util.List;

public class BigliettiDAO {
    Connection connection;
    public BigliettiDAO(){
        this.connection = DatabaseConnection.getConnection();
    }
    public void addTicket(Ticket ticket){

    }
    public Ticket getTicketById(int id){
        return null;
    }
    public List<Ticket> getTicketByUserEmail(String userEmail){ //L'USER ID è LA MAIL
        return null;
    }
    public List<Ticket> getAllTickets(){
        return null;
    }
    public void updateTicket(Ticket ticket){

    }
    public void deleteTicket(int id){

    }
}
