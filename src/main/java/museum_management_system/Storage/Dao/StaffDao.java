package museum_management_system.Storage.Dao;
import museum_management_system.Storage.Model.Staff;
import museum_management_system.Storage.Utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDao {

    private final Connection connection = DatabaseConnection.connection;

    public Staff SerchStaff(String email, String password) {
        try {
            String sql = "SELECT * FROM Staff WHERE staff_email = ? and staff_password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            Staff staff = null;
            if ( resultSet.next() ){
                staff = new Staff(
                        resultSet.getInt("staff_id"),
                        resultSet.getString("staff_cf"),
                        resultSet.getString("staff_name"),
                        resultSet.getString("staff_surname"),
                        resultSet.getString("staff_email"),
                        resultSet.getString("staff_password"),
                        resultSet.getDouble("staff_salary"),
                        resultSet.getString("type_contract")
                );
            } else return null;
            resultSet.close(); statement.close();
            return staff;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Staff> GetStaff() {
        try {
            String sql = "SELECT * FROM Staff";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Staff> staffs = new ArrayList<>();
            if ( !resultSet.next() ){
                return null;
            } else do {
                Staff staff = new Staff(resultSet.getInt("staff_id"),
                        resultSet.getString("staff_cf"),
                        resultSet.getString("staff_name"),
                        resultSet.getString("staff_surname"),
                        resultSet.getString("staff_email"),
                        resultSet.getString("staff_password"),
                        resultSet.getDouble("staff_salary"),
                        resultSet.getString("type_contract")
                );
                staffs.add(staff);
            } while (resultSet.next());
            resultSet.close();
            return staffs;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void InsertStaff(Staff staff) {
        try {
            String sql = "INSERT INTO Staff (staff_cf, staff_name, staff_surname, staff_email, staff_password, staff_salary, type_contract ) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, staff.getStaff_cf());
            statement.setString(2, staff.getName());
            statement.setString(3, staff.getSurname());
            statement.setString(4, staff.getEmail());
            statement.setString(5, staff.getPassword());
            statement.setDouble(6, staff.getSalary());
            statement.setString(7, staff.getContract());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean UpdateStaff(Staff staff) {
        try {
            String sql = "UPDATE Staff SET staff_cf = ?, staff_name = ?, staff_surname = ?, staff_email = ?, staff_password = ?, staff_salary = ?, type_contract = ? WHERE staff_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, staff.getStaff_cf());
            statement.setString(2, staff.getName());
            statement.setString(3, staff.getSurname());
            statement.setString(4, staff.getEmail());
            statement.setString(5, staff.getPassword());
            statement.setDouble(6, staff.getSalary());
            statement.setString(7, staff.getContract());
            statement.setInt(8, staff.getStaff_id());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean DeleteStaff(int staff_id) {
        try {
            String sql = "DELETE FROM Staff WHERE staff_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, staff_id);
            int result = statement.executeUpdate();
            statement.close();
            return result == 1;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
