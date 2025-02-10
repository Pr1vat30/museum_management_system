package museum_management_system.Application.Service;

import museum_management_system.Storage.Dao.AdminDao;
import museum_management_system.Storage.Dao.StaffDao;
import museum_management_system.Storage.Dao.UserDao;
import museum_management_system.Storage.Utils.Validators.UserValidator;

public class AuthService {

    public Object login(String email, String password) {
        try {
            // Validazione input
            UserValidator.validateEmail(email);
            UserValidator.validatePassword(password);

            if (email.contains(".admin")) {
                AdminDao adminDao = new AdminDao();
                return adminDao.SerchAdmin(email, password);
            }

            else if (email.contains(".staff")) {
                StaffDao staffDao = new StaffDao();
                return staffDao.SerchStaff(email, password);
            }

            else {
                UserDao userDao = new UserDao();
                return userDao.SerchUser(email, password);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Errore di validazione: " + e.getMessage());
            return null;
        }
    }
}