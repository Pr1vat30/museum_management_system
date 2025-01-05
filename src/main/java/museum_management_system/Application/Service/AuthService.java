package museum_management_system.Application.Service;

import museum_management_system.Storage.Dao.AdminDao;
import museum_management_system.Storage.Dao.UserDao;

public class AuthService {

    public Object login(String email, String password) {

        Object user = null;

        if ( email.contains("admin") ){
            AdminDao dao = new AdminDao();
            user = dao.SerchAdmin(email, password);
        } else {
            UserDao dao = new UserDao();
            user = dao.SerchUser(email, password);
        }

        return user;
    }
}