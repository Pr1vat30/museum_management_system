package museum_management_system.Application.Service;
import museum_management_system.Storage.Dao.StaffDao;
import museum_management_system.Storage.Model.Staff;

import java.util.List;

public class StaffService {

    public List<Staff> save(Staff staff) {
        StaffDao staffDao = new StaffDao();
        staffDao.InsertStaff(staff);
        return staffDao.GetStaff();
    }

    public List<Staff> delete(int staff_id) {
        StaffDao staffDao = new StaffDao();
        staffDao.DeleteStaff(staff_id);
        return staffDao.GetStaff();
    }

    public List<Staff> update(Staff staff) {
        StaffDao staffDao = new StaffDao();
        staffDao.UpdateStaff(staff);
        return staffDao.GetStaff();
    }

    public List<Staff> get() {
        StaffDao staffDao = new StaffDao();
        return staffDao.GetStaff();
    }
}
