package service_MA;

import dao_MA.BookingDAO_MA;
import model_MA.Booking_MA;

import java.sql.SQLException;
import java.util.List;

public class BookingService_MA {

    private BookingDAO_MA bookingDAO = new BookingDAO_MA();

    // -----------------------------------------------------------
    // إضافة حجز جديد
    // -----------------------------------------------------------
    public void addBooking(Booking_MA booking) throws SQLException {
        bookingDAO.insertBooking(booking);
    }

    // -----------------------------------------------------------
    // جلب كل الحجوزات
    // -----------------------------------------------------------
    public List<Booking_MA> getAllBookings() throws SQLException {
        return bookingDAO.getAllBookings();
    }

    // -----------------------------------------------------------
    // البحث عن الحجوزات (بالاسم أو القاعة أو التاريخ)
    // -----------------------------------------------------------
    public List<Booking_MA> searchBookings(String customerName, String hall, String date) throws SQLException {
        return bookingDAO.searchBookings(customerName, hall, date);
    }
}
