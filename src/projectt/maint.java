  package projectt;                                  

import model_MA.customer_MA;
import model_MA.hall_MA;
import model_MA.Booking_MA:
import java.util.ArrayList;                        
import java.util.InputMismatchException;           
import java.util.List;                             
import java.util.Scanner;                          

public class maint {                               
    static Scanner inputt = new Scanner(System.in);
    static List<hall_MA> hallst = new ArrayList<>(); // لست لتخزين كل القاعات 
    static List<customer_MA> customerst = new ArrayList<>(); // لست لتخزين كل الزبائن
    static List<String> bookingst = new ArrayList<>(); // لست  تخزن فيها الحجوزات (اسم زبون+قاعه)
    public static void main(String[] args) {       
        int choicet;    // متغير يخزن اختيار المستخدم من القائمة
        do {                                       
            System.out.println("==== Wedding Hall Booking System (T) ===="); // طباعة عنوان النظام
            System.out.println("1. Add new hall");   // خيار 1: إضافة قاعة
            System.out.println("2. Add new customer");  // خيار 2: إضافة زبون
            System.out.println("3. Make booking");  // خيار 3: حجز
            System.out.println("4. List halls");    // خيار 4: عرض كل القاعات
            System.out.println("5. List customers"); // خيار 5: عرض كل الزبائن
            System.out.println("6. List bookings");  // خيار 6: عرض كل الحجوزات المخزن
            System.out.println("7. Search hall by ID"); // بحث عن قاعة بالـ ID
            System.out.println("8. Search customer by ID");// بحث عن زبون بالـ ID
            System.out.println("9. Update hall (capacity & price)"); 
            System.out.println("10. Update customer (name & phone)"); 
            System.out.println("11. Delete hall by ID");
            System.out.println("12. Delete customer by ID");
            System.out.println("0. Exit");  // خيار 0: خروج
            System.out.print("Enter choice: ");   // نطلب من المستخدم يدخل رقم

            choicet = readIntSafet("choice");   //  نقرا رقم الاختيار باستخدام دالة فيها try/catch 
            switch (choicet) {             
                case 1:  addhallt();   break; 
                case 2 : addcustomert();     break;                  
                case 3 : makebookingt(); break;
                case 4 : listhallst();  break;
                case 5 : listcustomerst();  break; 
                case 6:  listbookingt();  break; 
                case 7:  searchHallByIdt();  break;
                case 8:  searchCustomerByIdt();  break;
                case 9:  updateHallt(); break;
                case 10: updateCustomert();  break;
                case 11: deleteHallt(); break;
                case 12: deleteCustomert(); break;
                case 0: System.out.println("Bye :)");  break;     // نطبع رسالة وداع
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
        String bookingLine = chosencustomer.getCustomernamet() + " booked hall "+ chosentHall.getHallnamet(); 
        bookingst.add(bookingLine);  // نضيف نص الحجز لليست الحجوزات bookingst
        System.out.println("Booking done: " + chosencustomer.getCustomernamet() + " booked hall " + chosentHall.getHallnamet()); }// نطبع نتيجة الحجزاسم الزبون والقاعه
    
    // --- دالة عرض القاعات ---
    static void listhallst() {  
        System.out.println("== Halls List ==");  // عنوان القسم
        if (hallst.isEmpty()) {
            System.out.println("No halls found.");
        } else {
            printListt(hallst);
        }
    }

    // --- دالة عرض الزبائن ---
    static void listcustomerst() { 
        System.out.println("== Customers List =="); 
        if (customerst.isEmpty()) {  
            System.out.println("No customers found.");
        } else { 
            printListt(customerst); 
        }
    }

    // ---دالة عرض الحجوزات ---
    static void listbookingt() { 
        System.out.println("== Bookings List =="); 
        if (bookingst.isEmpty()) { 
            System.out.println("No bookings found.");
        } else {
            for (int i = 0; i < bookingst.size(); i++) { // نلف على كل عنصر في لست bookingst
                System.out.println((i + 1) + ") " + bookingst.get(i)); // نطبع رقم الحجز + نص الحجز
            }
        }
    }    
    // --- بحث عن قاعة بالـ ID دالة---
    static void searchHallByIdt() {
        System.out.println("== Search Hall By ID ==");
        if (hallst.isEmpty()) {
            System.out.println("No halls found.");
            return; }
        System.out.print("Enter hall ID to search: ");
        int idt = readIntSafet("hall ID"); //نقرا id لنبي نلقاه
        int index = findHallIndexByIdt(idt);  // نلقى رقم المكان في اللست
        if (index == -1) {  // -1 هش لاقي
            System.out.println("Hall not found!");
        } else {
            System.out.println("Hall found: " + hallst.get(index)); // يطبع بيانات القاعة
        }
    }

    // ---بحث عن زبون بالـ ID دالة---
    static void searchCustomerByIdt() {
        System.out.println("== Search Customer By ID ==");
        if (customerst.isEmpty()) {
            System.out.println("No customers found.");
            return; }
        System.out.print("Enter customer ID to search: ");
        int idt = readIntSafet("customer ID");
        int index = findCustomerIndexByIdt(idt);
        if (index == -1) {
            System.out.println("Customer not found!");
        } else {
            System.out.println("Customer found: " + customerst.get(index));
        }
    }

    // ---دالة تحديث بيانات قاعة ---
    static void updateHallt() {
        System.out.println("== Update Hall ==");
        if (hallst.isEmpty()) {
            System.out.println("No halls found.");
            return;}
        System.out.print("Enter hall ID to update: ");
        int idt = readIntSafet("hall ID");
        int index = findHallIndexByIdt(idt);
        if (index == -1) {
            System.out.println("Hall not found!");
            return;}
        hallt oldHall = hallst.get(index); // القاعة القديمة
        System.out.println("Current data: " + oldHall);    // عرض بياناتها الحالية
        System.out.print("Enter new capacity: ");
        int newCapacityt = readIntSafet("new capacity"); 
        System.out.print("Enter new price: ");
        double newPricet = readDoubleSafet("new price"); 
        hallt updatedHall = new hallt(oldHall.getHallidt(),oldHall.getHallnamet(),newCapacityt,newPricet); // ننشئ object جديد بنفس الـ ID والاسم لكن بسعة وسعر جديد
        hallst.set(index, updatedHall);  // تبديل القديمة بالجديدة
        System.out.println("Hall updated successfully!");
    }

    // ---دالة تحديث بيانات زبون ---
    static void updateCustomert() {
        System.out.println("== Update Customer ==");
        if (customerst.isEmpty()) {
            System.out.println("No customers found.");
            return; }
        System.out.print("Enter customer ID to update: ");
        int idt = readIntSafet("customer ID");
        int index = findCustomerIndexByIdt(idt); 
        if (index == -1) {
            System.out.println("Customer not found!");
            return;  }
        customert oldCustomer = customerst.get(index); 
        System.out.println("Current data: " + oldCustomer);
        System.out.print("Enter new name: ");
        String newNamet = inputt.nextLine();
        System.out.print("Enter new phone: ");
        String newPhonet = inputt.nextLine(); 
        if (newNamet.isEmpty() || newPhonet.isEmpty()) { 
            System.out.println("Name and phone cannot be empty.");
            return; }
        customert updatedCustomer = new customert(oldCustomer.getCustomeridt(),newNamet, newPhonet);
        customerst.set(index, updatedCustomer); // نبدل القديم بالجديد
        System.out.println("Customer updated successfully!");
    }

    // ---دالة حذف قاعة ---
    static void deleteHallt() {
        System.out.println("== Delete Hall ==");
        if (hallst.isEmpty()) {
            System.out.println("No halls found.");
            return;}
        System.out.print("Enter hall ID to delete: ");
        int idt = readIntSafet("hall ID");
        int index = findHallIndexByIdt(idt); 
        if (index == -1) {
            System.out.println("Hall not found!");
            return; }
        hallst.remove(index);
        System.out.println("Hall deleted successfully!");
    }

    // ---دالة حذف زبون ---
    static void deleteCustomert() {
        System.out.println("== Delete Customer ==");
        if (customerst.isEmpty()) {
            System.out.println("No customers found.");
            return; }
        System.out.print("Enter customer ID to delete: ");
        int idt = readIntSafet("customer ID");
        int index = findCustomerIndexByIdt(idt);
        if (index == -1) {
            System.out.println("Customer not found!");
            return;}
        customerst.remove(index); 
        System.out.println("Customer deleted successfully!");
    }

    // ---دوال للبحث عن index بالـ ID ---
    static int findHallIndexByIdt(int idt) {  // ترجع index القاعة حسب ID
        for (int i = 0; i < hallst.size(); i++) {
            if (hallst.get(i).getHallidt() == idt) {
                return i;}     // نرجع رقم المكان
        }
        return -1; // -1 يعني مش لاقي
    }
    static int findCustomerIndexByIdt(int idt) {
        for (int i = 0; i < customerst.size(); i++) {
            if (customerst.get(i).getCustomeridt() == idt) {
                return i;}
        }
        return -1;
    }
    //--- دالة عامة لطباعة اي list (generic) ---
    static <T> void printListt(List<T> listt) {
        for (int i = 0; i < listt.size(); i++) {    
            System.out.println((i + 1) + ") " + listt.get(i)); // نطبع رقم العنصر + قيمته (toString)
        }
    }
}
