package projectt;

public class hallt {
    private int hallidt;
    private String hallnamet;
    private int capacityt;
    private double pricet;

    // Constructor – يشتغل أول ما ندير new hallt(...)
    public hallt(int hallidt, String hallnamet, int capacityt, double pricet) {
        this.hallidt = hallidt;
        this.hallnamet = hallnamet;
        this.capacityt = capacityt;
        this.pricet = pricet;
    }
    //  يقرا القيم من برا الكلاس
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
    // يغير سعر القاعه لو صار  تعديل 
    public void setPricet(double pricet) {
        this.pricet = pricet;
    }
    // ترجع نص يمثل القاعه
    @Override
    public String toString() {
        return "Hall ID: " + hallidt +
               ", Name: " + hallnamet +
               ", Capacity: " + capacityt +
               ", Price: " + pricet;
    }
}
    