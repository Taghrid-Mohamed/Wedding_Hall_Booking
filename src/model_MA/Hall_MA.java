package model_MA;

public class Hall_MA {

    private int id;
    private String name;
    private int capacity;
    private double price;
    private String status;

    public Hall_MA() {
    }

    public Hall_MA(int id, String name, int capacity, double price, String status) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.status = status;
    }

    // Constructor بدون ID (لما نضيف جديد والداتا بيز تولّد الـ ID)
    public Hall_MA(String name, int capacity, double price, String status) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.status = status;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
