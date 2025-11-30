package projectt;                                  

import java.util.ArrayList;                        
import java.util.InputMismatchException;           
import java.util.List;                             
import java.util.Scanner;                          

public class maint {                               
    static Scanner inputt = new Scanner(System.in);
    static List<hallt> hallst = new ArrayList<>(); // لست لتخزين كل القاعات 
    static List<customert> customerst = new ArrayList<>(); // لست لتخزين كل الزبائن

    public static void main(String[] args) {       
        int choicet;    // متغير يخزن اختيار المستخدم من القائمة
        do {                                       
            System.out.println("==== Wedding Hall Booking System (T) ===="); // طباعة عنوان النظام
            System.out.println("1. Add new hall");      // خيار 1: إضافة قاعة
            System.out.println("2. Add new customer");  // خيار 2: إضافة زبون
            System.out.println("3. Make booking");      // خيار 3: حجز
            System.out.println("4. List halls");        // خيار 4: عرض كل القاعات
            System.out.println("5. List customers");    // خيار 5: عرض كل الزبائن
            System.out.println("0. Exit");              // خيار 0: خروج
            System.out.print("Enter choice: ");         // نطلب من المستخدم يدخل رقم

            choicet = readIntSafet("choice");           //  نقرا رقم الاختيار باستخدام دالة فيها try/catch 
            switch (choicet) {             
                case 1: 
                    addhallt();   break; 
                case 2 : 
                    addcustomert();     break;                  
                case 3 : 
                    makebookingt(); break;
                case 4 : 
                    listhallst();  break;
                case 5 : 
                    listcustomerst();  break;                  
                case 0: 
                    System.out.println("Bye T :)");  break;     // نطبع رسالة وداع
                default : 
                    System.out.println("Invalid choice!");   break;  // نطبع إن الاختيار غلط
            }
                     
        } while (choicet != 0);                      
    }
    //دوال تتاكد من صحة المدخلات 
    static int readIntSafet(String fieldNamet) {    //تتاكد ان المدخل int
        while (true) {  
            try {
               int valuet=inputt.nextInt();
                inputt.nextLine();
                return valuet;                          
            } catch (InputMismatchException e) {        // لو المستخدم كتب حروف بدل رقم
                System.out.println("Please enter a valid integer for " + fieldNamet + "!"); // رسالة خطأ
                inputt.nextLine();                      // نمسح الإدخال الغلط من الـ buffer
                System.out.print("Try again: ");
            }
        }
    }
    static double readDoubleSafet(String fieldNamet) {  // تتاكد ان المدخل double
        while (true) { 
            try {
                double valuet = inputt.nextDouble();
                inputt.nextLine();
                return valuet;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for " + fieldNamet + "!"); // رسالة خطأ
                inputt.nextLine();
                System.out.print("Try again: "); 
            }
        }
    }
    // --- دالة اضافة قاعة ---
    static void addhallt() { 
        System.out.println("== Add New Hall =="); // عنوان العملية
        System.out.print("Enter hall ID: "); 
        int idt = readIntSafet("hall ID"); // نقرا ID باستخدام الدالة الآمنة
        System.out.print("Enter hall name: ");
        String namet = inputt.nextLine();
        System.out.print("Enter capacity: ");
        int capacityt = readIntSafet("capacity");
        System.out.print("Enter price: ");
        double pricet = readDoubleSafet("price");
        try { 
            if (namet.isEmpty()) { 
                throw new IllegalArgumentException("Hall name cannot be empty");   }
            if (capacityt <= 0) { 
                throw new IllegalArgumentException("Capacity must be > 0");   }
            if (pricet <= 0) { 
                throw new IllegalArgumentException("Price must be > 0");   }
            hallt newHallt = new hallt(idt, namet, capacityt, pricet); // ننشئ  قاعة جديدة
            hallst.add(newHallt);
            System.out.println("Hall added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error while adding hall: " + e.getMessage());
        }
    }

    //---  دالة اضافة زبون---
    static void addcustomert() {
        System.out.println("== Add New Customer ==");   // عنوان العملية
        System.out.print("Enter customer ID: "); 
        int idt = readIntSafet("customer ID");
        System.out.print("Enter customer name: ");
        String namet = inputt.nextLine();
        System.out.print("Enter phone: ");
        String phonet = inputt.nextLine();
        try {
            if (namet.isEmpty()) {
                throw new IllegalArgumentException("Customer name cannot be empty"); }
            if (phonet.isEmpty()) {
                throw new IllegalArgumentException("Phone cannot be empty");  }
            customert newCustomert = new customert(idt, namet, phonet); //ننشئ object زبون
            customerst.add(newCustomert);
            System.out.println("Customer added successfully!"); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error while adding customer: " + e.getMessage());
        }
    }
    // --- دالة الحجز ---
    static void makebookingt() {  // دالة تقوم بعملية الحجز بين زبون و قاعة
        System.out.println("== Make Booking ==");   
        if (hallst.isEmpty() || customerst.isEmpty()) { 
            System.out.println("You must add halls and customers first!"); //  نطلب يضيف قبل
            return; }
        System.out.println("Available halls:"); // نطبع القاعات المتاحة
        printListt(hallst);  //نستخدم دالة generic لعرض الليست
        System.out.print("Choose hall number (index starting from 1): "); 
        int hallIndext = readIntSafet("hall index") - 1; 
        if (hallIndext < 0 || hallIndext >= hallst.size()) { 
            System.out.println("Invalid hall index!");  
            return;   }
        System.out.println("Available customers:"); // نطبع الزبائن المتاحين
        printListt(customerst); 
        System.out.print("Choose customer number (index starting from 1): ");
        int customerIndext = readIntSafet("customer index") - 1;
        if (customerIndext < 0 || customerIndext >= customerst.size()) { 
            System.out.println("Invalid customer index!");
            return; }
        hallt chosentHall = hallst.get(hallIndext);   // نجيب القاعة المختارة من الليست
        customert chosencustomer = customerst.get(customerIndext); // نجيب الزبون المختار
        System.out.println("Booking done: "  // نطبع نتيجة الحجزاسم الزبون والقاعه
                + chosencustomer.getCustomernamet() + " booked hall " + chosentHall.getHallnamet()); }
    
    //دوال لعرض الليست 
    static void listhallst() {  // دالة لعرض كل القاعات
        System.out.println("== Halls List =="); // عنوان
        if (hallst.isEmpty()) { 
            System.out.println("No halls found."); 
        } else {   
            printListt(hallst);   // نطبع الليست بدالة generic
        }
    }
    static void listcustomerst() {  // دالة لعرض كل الزبائن
        System.out.println("== Customers List ==");
        if (customerst.isEmpty()) { 
            System.out.println("No customers found."); 
        } else { 
            printListt(customerst); 
        }
    }
    //  دالة Generic لطباعة أي List
    static <T> void printListt(List<T> listt) {          // دالة generic تقبل List من أي نوع T
        for (int i = 0; i < listt.size(); i++) {    
            System.out.println((i + 1) + ") " + listt.get(i)); // نطبع رقم العنصر + قيمته (toString)
        }
    }
}