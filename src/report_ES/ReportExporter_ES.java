package report_ES;

import java.io.PrintWriter;
import java.util.List;
import model_MA.Booking_MA;

public class ReportExporter_ES {

    // عضو 3: مسؤول عن تصدير الحجوزات لملف تقارير
    public static void exportBookingsToTxt(List<Booking_MA> list, String fileName) throws Exception {

        try (PrintWriter writer = new PrintWriter(fileName)) {

            // العنوان
            writer.println("BookingID\tHall\tCustomer\tDate\tGuests\tTotalPrice");

            // نكتب كل حجز في سطر
            for (Booking_MA b : list) {
                double totalPrice = b.getGuests() * 100.0;   // نفس الفكرة اللي في التقارير

                writer.println(
                        b.getId() + "\t" +
                        b.getHall() + "\t" +
                        b.getCustomerName() + "\t" +
                        b.getDate() + "\t" +
                        b.getGuests() + "\t" +
                        totalPrice
                );
            }
        }
    }
}
