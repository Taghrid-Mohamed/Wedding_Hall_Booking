package model_MA;

public class customer_MA {

    private int customeridt;
    private String customernamet;
    private String phonet;

    public customer_MA(int customeridt, String customernamet, String phonet) {
        this.customeridt = customeridt;
        this.customernamet = customernamet;
        this.phonet = phonet;
    }

    public int getCustomeridt() {
        return customeridt;
    }

    public String getCustomernamet() {
        return customernamet;
    }

    public String getPhonet() {
        return phonet;
    }

    public void setCustomernamet(String customernamet) {
        this.customernamet = customernamet;
    }
    public void setPhonet(String phonet) {
        this.phonet = phonet;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customeridt +
                ", Name: " + customernamet +
                ", Phone: " + phonet;
    }
}
