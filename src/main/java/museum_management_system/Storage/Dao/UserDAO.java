package museum_management_system.Storage.Dao;

import museum_management_system.Storage.Model.DatabaseConnection;
import museum_management_system.Storage.Model.Ticket;
import museum_management_system.Storage.Model.User;

import java.sql.Connection;
import java.util.List;

public class UserDAO {
    Connection connection;
    public UserDAO(){
        this.connection = DatabaseConnection.getConnection();
    }
    public boolean addUser(User user){
        return true;
    }
    public User getUserById(int id){
        return null;
    }
    public User getUserByEmail(String email){
        return null;
    }
    public List<User> getAllUsers(){
        return null;
    }
    public User updateUser(User newUser){
        return null;
    }
    public boolean deleteUsers(int id){
        return true;
    }
}
