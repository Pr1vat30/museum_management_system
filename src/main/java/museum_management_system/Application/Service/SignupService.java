package museum_management_system.Application.Service;

import java.util.Map;

import museum_management_system.Storage.Dao.UserDao;
import museum_management_system.Storage.Model.PayMethod;
import museum_management_system.Storage.Model.User;

public class SignupService {

    public User save(User user, PayMethod payMethod) {
        if ( validateUserData(user) ) {
            UserDao dao = new UserDao();
            return dao.InsertUser(user, payMethod);
        } else return null;
    }

    public boolean validateUserData(User user) {
        return true;
    }
}