package model_MA;

public class hall_MA {

    private int hallidt;
    private String hallnamet;
    private int capacityt;
    private double pricet;

    public hall_MA(int hallidt, String hallnamet, int capacityt, double pricet) {
        this.hallidt = hallidt;
        this.hallnamet = hallnamet;
        this.capacityt = capacityt;
        this.pricet = pricet;
    }

    public int getHallidt() {
        return hallidt;
    }

    public String getHallnamet() {
        return hallnamet;
    }

    public int getCapacityt() {
        return capacityt;
    }

    public double getPricet() {
        return pricet;
    }

    public void setCapacityt(int capacityt) {
        this.capacityt = capacityt;
    }

    public void setPricet(double pricet) {
        this.pricet = pricet;
    }
    @Override
    public String toString() {
        return "Hall ID: " + hallidt +
                ", Name: " + hallnamet +
                ", Capacity: " + capacityt +
                ", Price: " + pricet;
    }
}
