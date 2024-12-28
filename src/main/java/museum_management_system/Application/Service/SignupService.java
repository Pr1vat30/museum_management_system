package museum_management_system.Application.Service;

import java.util.Map;

import museum_management_system.Storage.Dao.UserDao;
import museum_management_system.Storage.Model.User;

public class SignupService {

    public User save(Map<String, Object> jsonMap) {
        User user = new User(
                (String) jsonMap.get("username"),
                (String) jsonMap.get("email"),
                (String) jsonMap.get("password"),
                (String) jsonMap.get("phone")
        );

        if ( validateUserData(user) ) {
            UserDao dao = new UserDao();
            return dao.InsertUser(user);
        } else return null;
    }

    public boolean validateUserData(User user) {
        return true;
    }
}