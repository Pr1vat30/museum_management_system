package museum_management_system.Storage.Dao;

import museum_management_system.Storage.Model.DatabaseConnection;
import museum_management_system.Storage.Model.Mostra;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class MostraDAO {
    Connection connection;
    public MostraDAO(){
        this.connection = DatabaseConnection.getConnection();
    }
    public boolean addEvent(Mostra evento){
        return true;
    }
    public Mostra getEventById(int id){
        return null;
    }
    public List<Mostra> getEventByDate(LocalDate date){
        return null;
    }
    public List<Mostra> getAllEvent(){
        return null;
    }
    public boolean updateEvent(Mostra newMostra){
        return true;
    }
    public boolean deleteEvent(int id){
        return true;
    }
}
