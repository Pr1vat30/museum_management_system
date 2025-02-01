package museum_management_system.Application.Service;
import museum_management_system.Storage.Dao.StaffDao;
import museum_management_system.Storage.Model.Staff;

import java.util.List;
import java.util.Map;

public class StaffService {

    public List<Staff> save(Map<String, Object> jsonMap) {
        Staff staff = new Staff(
                (String) jsonMap.get("cf"),
                (String) jsonMap.get("name"),
                (String) jsonMap.get("surname"),
                (String) jsonMap.get("email"),
                (String) jsonMap.get("password"),
                Double.parseDouble((String) jsonMap.get("salary")),
                (String) jsonMap.get("contract")
        );
        StaffDao staffDao = new StaffDao();
        staffDao.InsertStaff(staff);
        return staffDao.GetStaff();
    }

    public List<Staff> delete(int staff_id) {
        StaffDao staffDao = new StaffDao();
        staffDao.DeleteStaff(staff_id);
        return staffDao.GetStaff();
    }

    public List<Staff> update(Map<String, Object> jsonMap) {
        Staff staff = new Staff(
                (String) jsonMap.get("cf"),
                (String) jsonMap.get("name"),
                (String) jsonMap.get("surname"),
                (String) jsonMap.get("email"),
                (String) jsonMap.get("password"),
                Double.parseDouble((String) jsonMap.get("salary")),
                (String) jsonMap.get("contract")
        );
        staff.setStaff_id(Integer.parseInt((String) jsonMap.get("staff_id")));
        StaffDao staffDao = new StaffDao();
        staffDao.UpdateStaff(staff);
        return staffDao.GetStaff();
    }

    public List<Staff> get() {
        StaffDao staffDao = new StaffDao();
        return staffDao.GetStaff();
    }
}
