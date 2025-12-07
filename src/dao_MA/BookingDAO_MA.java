package dao_MA;

import db_MA.DBConnection_MA;
import model_MA.Booking_MA;
import util_ES.LoggerUtil_ES;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO_MA {

    // -----------------------------------------------------------
    // INSERT: إضافة حجز جديد
    // -----------------------------------------------------------
    public void insertBooking(Booking_MA booking) throws SQLException {
        String sql = "INSERT INTO bookings (hall, customerName, phone, date, guests) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection_MA.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, booking.getHall());
            ps.setString(2, booking.getCustomerName());
            ps.setString(3, booking.getPhone());
            ps.setString(4, booking.getDate());
            ps.setInt(5, booking.getGuests());

            ps.executeUpdate();
             LoggerUtil_ES.logInfo("Booking inserted for customer: " + booking.getCustomerName());

    } catch (SQLException e) {
        LoggerUtil_ES.logError("insertBooking failed: " + e.getMessage());
        throw e;
    }
        
    }

    // -----------------------------------------------------------
    // SELECT ALL: جلب كل الحجوزات
    // -----------------------------------------------------------
    public List<Booking_MA> getAllBookings() throws SQLException {
        String sql = "SELECT * FROM bookings";
        List<Booking_MA> list = new ArrayList<>();

        try (Connection conn = DBConnection_MA.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Booking_MA b = new Booking_MA();
                b.setId(rs.getInt("id"));
                b.setHall(rs.getString("hall"));
                b.setCustomerName(rs.getString("customerName"));
                b.setPhone(rs.getString("phone"));
                b.setDate(rs.getString("date"));
                b.setGuests(rs.getInt("guests"));
                list.add(b);
            }
        }
        return list;
    }

    // -----------------------------------------------------------
    // SEARCH: البحث حسب الاسم أو القاعة أو التاريخ (اختياريين)
    // -----------------------------------------------------------
    public List<Booking_MA> searchBookings(String customerName, String hall, String date) throws SQLException {

        StringBuilder sql = new StringBuilder("SELECT * FROM bookings WHERE 1=1");
        List<Object> params = new ArrayList<>();

        // بحث بالاسم
        if (customerName != null && !customerName.isEmpty()) {
            sql.append(" AND customerName LIKE ?");
            params.add("%" + customerName + "%");
        }

        // بحث بالقاعة
        if (hall != null && !hall.isEmpty()) {
            sql.append(" AND hall LIKE ?");
            params.add("%" + hall + "%");
        }

        // بحث بالتاريخ
        if (date != null && !date.isEmpty()) {
            sql.append(" AND date = ?");
            params.add(date);
        }

        List<Booking_MA> list = new ArrayList<>();

        try (Connection conn = DBConnection_MA.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            // تعبئة الـ parameters في الـ PreparedStatement
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Booking_MA b = new Booking_MA();
                    b.setId(rs.getInt("id"));
                    b.setHall(rs.getString("hall"));
                    b.setCustomerName(rs.getString("customerName"));
                    b.setPhone(rs.getString("phone"));
                    b.setDate(rs.getString("date"));
                    b.setGuests(rs.getInt("guests"));
                    list.add(b);
                }
            }
        }

        return list;
    }
}
