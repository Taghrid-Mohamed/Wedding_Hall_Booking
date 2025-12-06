package dao_MA;

import db_MA.DBConnection_MA;
import model_MA.Hall_MA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HallDAO_MA {

    public void insertHall(Hall_MA hall) throws SQLException {
        String sql = "INSERT INTO halls (name, capacity, price, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection_MA.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, hall.getName());
            ps.setInt(2, hall.getCapacity());
            ps.setDouble(3, hall.getPrice());
            ps.setString(4, hall.getStatus());

            ps.executeUpdate();
        }
    }

    public void updateHall(Hall_MA hall) throws SQLException {
        String sql = "UPDATE halls SET name=?, capacity=?, price=?, status=? WHERE id=?";

        try (Connection conn = DBConnection_MA.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, hall.getName());
            ps.setInt(2, hall.getCapacity());
            ps.setDouble(3, hall.getPrice());
            ps.setString(4, hall.getStatus());
            ps.setInt(5, hall.getId());

            ps.executeUpdate();
        }
    }

    public void deleteHall(int id) throws SQLException {
        String sql = "DELETE FROM halls WHERE id=?";

        try (Connection conn = DBConnection_MA.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Hall_MA> getAllHalls() throws SQLException {
        String sql = "SELECT * FROM halls";
        List<Hall_MA> list = new ArrayList<>();

        try (Connection conn = DBConnection_MA.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Hall_MA hall = new Hall_MA();
                hall.setId(rs.getInt("id"));
                hall.setName(rs.getString("name"));
                hall.setCapacity(rs.getInt("capacity"));
                hall.setPrice(rs.getDouble("price"));
                hall.setStatus(rs.getString("status"));
                list.add(hall);
            }
        }
        return list;
    }
}
