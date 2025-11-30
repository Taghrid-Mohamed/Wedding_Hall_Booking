package projectt;

import model_MA.hall_MA;
import model_MA.customer_MA;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class maint {

    static Scanner inputt = new Scanner(System.in);
    static List<hall_MA> hallst = new ArrayList<>();
    static List<customer_MA> customerst = new ArrayList<>();
    static List<String> bookingst = new ArrayList<>();

    public static void main(String[] args) {
        int choicet;

        do {
            System.out.println("==== Wedding Hall Booking System ====");
            System.out.println("1. Add new hall");
            System.out.println("2. Add new customer");
            System.out.println("3. Make booking");
            System.out.println("4. List halls");
            System.out.println("5. List customers");
            System.out.println("6. List bookings");
            System.out.println("7. Search hall by ID");
            System.out.println("8. Search customer by ID");
            System.out.println("9. Update hall");
            System.out.println("10. Update customer");
            System.out.println("11. Delete hall");
            System.out.println("12. Delete customer");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choicet = readIntSafet("choice");

            switch (choicet) {
                case 1: addhallt(); break;
                case 2: addcustomert(); break;
                case 3: makebookingt(); break;
                case 4: listhallst(); break;
                case 5: listcustomerst(); break;
                case 6: listbookingt(); break;
                case 7: searchHallByIdt(); break;
                case 8: searchCustomerByIdt(); break;
                case 9: updateHallt(); break;
                case 10: updateCustomert(); break;
                case 11: deleteHallt(); break;
                case 12: deleteCustomert(); break;
                case 0: System.out.println("Bye :)"); break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choicet != 0);
    }

    static int readIntSafet(String fieldNamet) {
        while (true) {
            try {
                int valuet = inputt.nextInt();
                inputt.nextLine();
                return valuet;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer for " + fieldNamet + "!");
                inputt.nextLine();
                System.out.print("Try again: ");
            }
        }
    }

    static double readDoubleSafet(String fieldNamet) {
        while (true) {
            try {
                double valuet = inputt.nextDouble();
                inputt.nextLine();
                return valuet;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for " + fieldNamet + "!");
                inputt.nextLine();
                System.out.print("Try again: ");
            }
        }
    }

    static void addhallt() {
        System.out.println("== Add New Hall ==");
        System.out.print("Enter hall ID: ");
        int idt = readIntSafet("hall ID");

        System.out.print("Enter hall name: ");
        String namet = inputt.nextLine();

        System.out.print("Enter capacity: ");
        int capacityt = readIntSafet("capacity");

        System.out.print("Enter price: ");
        double pricet = readDoubleSafet("price");

        hall_MA hall = new hall_MA(idt, namet, capacityt, pricet);
        hallst.add(hall);
        System.out.println("Hall added successfully!");
    }

    static void addcustomert() {
        System.out.println("== Add New Customer ==");
        System.out.print("Enter customer ID: ");
        int idt = readIntSafet("customer ID");

        System.out.print("Enter customer name: ");
        String namet = inputt.nextLine();

        System.out.print("Enter phone: ");
        String phonet = inputt.nextLine();

        customer_MA cust = new customer_MA(idt, namet, phonet);
        customerst.add(cust);
        System.out.println("Customer added successfully!");
    }

    static void makebookingt() {
        System.out.println("== Make Booking ==");

        System.out.println("Available halls:");
        printListt(hallst);
        System.out.print("Choose hall number: ");
        int hallIndex = readIntSafet("index") - 1;

        System.out.println("Available customers:");
        printListt(customerst);
        System.out.print("Choose customer number: ");
        int customerIndex = readIntSafet("index") - 1;

        hall_MA h = hallst.get(hallIndex);
        customer_MA c = customerst.get(customerIndex);

        bookingst.add(c.getCustomernamet() + " booked hall " + h.getHallnamet());
        System.out.println("Booking completed!");
    }

    static void listhallst() {
        System.out.println("== Halls List ==");
        printListt(hallst);
    }

    static void listcustomerst() {
        System.out.println("== Customers List ==");
        printListt(customerst);
    }

    static void listbookingt() {
        System.out.println("== Bookings List ==");
        for (int i = 0; i < bookingst.size(); i++) {
            System.out.println((i + 1) + ") " + bookingst.get(i));
        }
    }

    static void searchHallByIdt() {
        System.out.println("== Search Hall ==");
        System.out.print("Enter hall ID: ");
        int id = readIntSafet("hall ID");

        for (hall_MA h : hallst) {
            if (h.getHallidt() == id) {
                System.out.println(h);
                return;
            }
        }
        System.out.println("Not found!");
    }

    static void searchCustomerByIdt() {
        System.out.println("== Search Customer ==");
        System.out.print("Enter customer ID: ");
        int id = readIntSafet("customer ID");

        for (customer_MA c : customerst) {
            if (c.getCustomeridt() == id) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Not found!");
    }

    static void updateHallt() {
        System.out.println("== Update Hall ==");
        System.out.print("Enter hall ID: ");
        int id = readIntSafet("hall ID");

        for (hall_MA h : hallst) {
            if (h.getHallidt() == id) {

                System.out.print("New capacity: ");
                int cap = readIntSafet("capacity");

                System.out.print("New price: ");
                double pr = readDoubleSafet("price");

                h.setCapacityt(cap);
                h.setPricet(pr);

                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("Not found!");
    }

    static void updateCustomert() {
        System.out.println("== Update Customer ==");
        System.out.print("Enter ID: ");
        int id = readIntSafet("ID");

        for (customer_MA c : customerst) {
            if (c.getCustomeridt() == id) {

                System.out.print("New name: ");
                String name = inputt.nextLine();

                System.out.print("New phone: ");
                String phone = inputt.nextLine();

                c.setCustomernamet(name);
                c.setPhonet(phone);

                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("Not found!");
    }

    static void deleteHallt() {
        System.out.println("== Delete Hall ==");
        System.out.print("Enter ID: ");
        int id = readIntSafet("ID");

        hallst.removeIf(h -> h.getHallidt() == id);
        System.out.println("Deleted!");
    }

    static void deleteCustomert() {
        System.out.println("== Delete Customer ==");
        System.out.print("Enter ID: ");
        int id = readIntSafet("ID");
        customerst.removeIf(c -> c.getCustomeridt() == id);
        System.out.println("Deleted!");
    }
    static <T> void printListt(List<T> listt) {
        for (int i = 0; i < listt.size(); i++) {
            System.out.println((i + 1) + ") " + listt.get(i));
        }
    }
}
