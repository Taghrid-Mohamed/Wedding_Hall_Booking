package report_ES;

import model_MA.Booking_MA;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

public class FileExporter_ES {

    // تصدير الحجوزات في ملف TXT
    public static void exportBookingsToTxt(List<Booking_MA> bookings, String fileName) throws IOException {

        try (PrintWriter writer = new PrintWriter(fileName)) {
            // الهيدر
            writer.println("ID\tHall\tCustomer\tPhone\tDate\tGuests\tTotal Price");

            // الصفوف
            for (Booking_MA b : bookings) {
                double totalPrice = b.getGuests() * 100.0;  // نفس الفكرة اللي في التقارير

                writer.printf(
                    "%d\t%s\t%s\t%s\t%s\t%d\t%.2f%n",
                    b.getId(),
                    b.getHall(),
                    b.getCustomerName(),
                    b.getPhone(),
                    b.getDate(),
                    b.getGuests(),
                    totalPrice
                );
            }
        }
    }

    // (اختياري) تصدير في CSV لو احتجتوها بعدين
    public static void exportBookingsToCsv(List<Booking_MA> bookings, String fileName) throws IOException {

        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println("id,hall,customer,phone,date,guests,totalPrice");

            for (Booking_MA b : bookings) {
                double totalPrice = b.getGuests() * 100.0;

                writer.printf(
                    "%d,%s,%s,%s,%s,%d,%.2f%n",
                    b.getId(),
                    escapeCsv(b.getHall()),
                    escapeCsv(b.getCustomerName()),
                    escapeCsv(b.getPhone()),
                    escapeCsv(b.getDate()),
                    b.getGuests(),
                    totalPrice
                );
            }
        }
    }

    // دالة مساعدة عشان لو الاسم فيه فاصلة أو علامات
    private static String escapeCsv(String value) {
        if (value == null) return "";
        if (value.contains(",") || value.contains("\"")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }
}
