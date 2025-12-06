package service_MA;

import dao_MA.UserDAO_MA;
import model_MA.User_MA;

import java.sql.SQLException;

public class UserService_MA {

    private UserDAO_MA userDAO = new UserDAO_MA();

    // دالة login ترجع User_MA لو صح، أو null لو غلط
    public User_MA login(String username, String password) throws SQLException {
        return userDAO.findByUsernameAndPassword(username, password);
    }
}
