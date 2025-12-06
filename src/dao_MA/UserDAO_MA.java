package dao_MA;

import db_MA.DBConnection_MA;
import model_MA.User_MA;

import java.sql.*;

public class UserDAO_MA {

    // نرجع User لو اليوزرنيم والباسورد صح، أو null لو غلط
    public User_MA findByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection_MA.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User_MA user = new User_MA();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getString("role"));
                    return user;
                } else {
                    return null; // مافيش يوزر بهالمعلومات
                }
            }
        }
    }
}
