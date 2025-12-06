package model_MA;

public class Booking_MA {

    private int id;
    private String hall;
    private String customerName;
    private String phone;
    private String date;
    private int guests;

    // Constructor فاضي (مطلوب عادي)
    public Booking_MA() {
    }

    // Constructor بكل الحقول (لما نجيب بيانات من الداتا بيز)
    public Booking_MA(int id, String hall, String customerName,
                      String phone, String date, int guests) {
        this.id = id;
        this.hall = hall;
        this.customerName = customerName;
        this.phone = phone;
        this.date = date;
        this.guests = guests;
    }

    // Constructor بدون id (لما نضيف حجز جديد)
    public Booking_MA(String hall, String customerName,
                      String phone, String date, int guests) {
        this.hall = hall;
        this.customerName = customerName;
        this.phone = phone;
        this.date = date;
        this.guests = guests;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }
}
