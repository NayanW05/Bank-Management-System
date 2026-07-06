/*package bank;
import java.util.*;
import bank.MainApp;

public class MainApp {
    public static void main(String[] args) {
        String role = Login.login();
         final Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MAIN MENU ===");

            if (role.equals("admin")) {
                System.out.println("1. Customer Management");
                System.out.println("2. Employee Management");
                System.out.println("3. ATM Mode");
                System.out.println("4. Exit");
                System.out.print("Choice: ");

                switch (MainApp.sc.nextInt()) {
                    case 1 -> CustomerDAO.customerMenu();
                    case 2 -> EmployeeDAO.employeeMenu();
                    case 3 -> ATMMode.startATM();
                    case 4 -> System.exit(0);
                }
            }
            else { // customer login
                System.out.println("1. ATM Mode");
                System.out.println("2. Exit");
                System.out.print("Choice: ");

                switch (MainApp.sc.nextInt()) {
                    case 1 -> ATMMode.startATM();
                    case 2 -> System.exit(0);
                }
            }
        }
    }
}

*/

package bank;
import java.util.Scanner;

public class MainApp {

    // THIS IS THE ONLY SCANNER FOR THE WHOLE PROJECT
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String role = Login.login();

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Customer Management");
            System.out.println("2. Employee Management");
           // System.out.println("3. ATM Mode");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int ch;
            try {
                ch = sc.nextInt();
                sc.nextLine(); // clear newline
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Invalid input!");
                continue;
            }

            switch (ch) {
                case 1 -> CustomerDAO.customerMenu();
                case 2 -> EmployeeDAO.employeeMenu();
                //e 3 -> ATMMode.startAM();
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }
}
