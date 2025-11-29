package projectt;                          

public class customert {                   
    private int customeridt;              
    private String customernamet;          
    private String phonet;                 

    public customert(int customeridt, String customernamet, String phonet) {
        // Constructor ينفذ لما نديرو new customert(...)
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
         
    @Override
    public String toString() {  //ترجع نص يمثل الزبون            
        return "Customer ID: " + customeridt
               + ", Name: " + customernamet
               + ", Phone: " + phonet;
    }
}