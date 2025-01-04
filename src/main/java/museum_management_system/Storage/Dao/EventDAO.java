package museum_management_system.Storage.Dao;

import museum_management_system.Storage.Model.DatabaseConnection;
import museum_management_system.Storage.Model.Event;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class EventDAO {
    Connection connection;
    public EventDAO(){
        this.connection = DatabaseConnection.getConnection();
    }
    public boolean addEvent(Event evento){
        return true;
    }
    public Event getEventById(int id){
        return null;
    }
    public List<Event> getEventByDate(LocalDate date){
        return null;
    }
    public List<Event> getAllEvent(){
        return null;
    }
    public boolean updateEvent(Event newEvent){
        return true;
    }
    public boolean deleteEvent(int id){
        return true;
    }
}
