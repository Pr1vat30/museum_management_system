package museum_management_system.Storage.Dao;

import museum_management_system.Storage.Model.Art;
import museum_management_system.Storage.Utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtsDao {

    private final Connection connection = DatabaseConnection.getConnection();

    public Art GetArtById(int art_id) {
        try {
            String sql = "SELECT * FROM Arts WHERE art_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, art_id);
            ResultSet resultSet = statement.executeQuery();
            Art art = null;
            if ( !resultSet.next() ){
                return null;
            } else do {
                art = new Art(resultSet.getInt("art_id"),
                        resultSet.getString("art_name"),
                        resultSet.getString("art_desc"),
                        resultSet.getString("art_artist"),
                        resultSet.getString("art_length"),
                        resultSet.getString("art_height"),
                        resultSet.getString("art_image")
                );
            } while (resultSet.next());
            resultSet.close();
            return art;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Art> GetArts() {
        try {
            String sql = "SELECT * FROM Arts";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Art> arts = new ArrayList<>();
            if ( !resultSet.next() ){
                return null;
            } else do {
                Art art = new Art(resultSet.getInt("art_id"),
                        resultSet.getString("art_name"),
                        resultSet.getString("art_desc"),
                        resultSet.getString("art_artist"),
                        resultSet.getString("art_length"),
                        resultSet.getString("art_height"),
                        resultSet.getString("art_image")
                );
                arts.add(art);
            } while (resultSet.next());
            resultSet.close();
            return arts;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void InsertArt(Art art) {
        try {
            String sql = "INSERT INTO Arts (art_name, art_desc, art_artist, art_length, art_height, art_image) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, art.getName());
            statement.setString(2, art.getDesc());
            statement.setString(3, art.getArtist());
            statement.setString(4, art.getLength());
            statement.setString(5, art.getHeight());
            statement.setString(6, art.getImage());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean UpdateArt(Art art) {
        try {
            String sql = "UPDATE Arts SET art_name = ?, art_desc = ?, art_artist = ?, art_length = ?,  art_height = ?, art_image = ? WHERE art_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, art.getName());
            statement.setString(2, art.getDesc());
            statement.setString(3, art.getArtist());
            statement.setString(4, art.getLength());
            statement.setString(5, art.getHeight());
            statement.setString(6, art.getImage());
            statement.setInt(7, art.getArt_id());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean DeleteArt(int art_id) {
        try {
            String sql = "DELETE FROM Arts WHERE art_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, art_id);
            int result = statement.executeUpdate();
            statement.close();
            return result == 1;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


}
