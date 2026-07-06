package bank;
import java.sql.*;
import java.util.*;
import bank.MainApp;

public class ATMMode {

    public static void startATM() {
        //MainApp.MainApp.scanner MainApp.MainApp.sc = new MainApp.scanner(System.in);
        try (Connection con = DBConnection.getConnection()) {

            System.out.print("\nEnter Customer ID: ");
            int cid = MainApp.sc.nextInt();
            MainApp.sc.nextLine();

            System.out.print("Enter ATM PIN: ");
            String pin = MainApp.sc.nextLine();

            PreparedStatement ps = con.prepareStatement(
              "SELECT acc_no,balance FROM account a JOIN customer c ON a.cust_id=c.cust_id WHERE c.cust_id=? AND c.atm_pin=?");
            ps.setInt(1, cid);
            ps.setString(2, pin);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Invalid Customer ID or PIN");
                return;
            }

            int acc = rs.getInt("acc_no");
            double bal = rs.getDouble("balance");

            while (true) {
                System.out.println("\n--- ATM MENU ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Change PIN");
                System.out.println("5. Exit ATM");
                System.out.print("Choice: ");

                int ch = MainApp.sc.nextInt();

                switch (ch) {
                    case 1 -> System.out.println("Balance: ₹" + bal);

                    case 2 -> {
                        System.out.print("Amount to Deposit: ");
                        double amt = MainApp.sc.nextDouble();
                        bal += amt;
                        con.createStatement().executeUpdate("UPDATE account SET balance=" + bal + " WHERE acc_no=" + acc);
                        System.out.println("Deposit Successful.");
                    }

                    case 3 -> {
                        System.out.print("Withdraw Amount: ");
                        double amt = MainApp.sc.nextDouble();
                        if (amt > bal) System.out.println("Insufficient Balance!");
                        else {
                            bal -= amt;
                            con.createStatement().executeUpdate("UPDATE account SET balance=" + bal + " WHERE acc_no=" + acc);
                            System.out.println("Withdrawal Successful.");
                        }
                    }

                    case 4 -> {
                        System.out.print("New PIN: ");
                        MainApp.sc.nextLine();
                        String newPin = MainApp.sc.nextLine();
                        PreparedStatement updatePin = con.prepareStatement("UPDATE customer SET atm_pin=? WHERE cust_id=?");
                        updatePin.setString(1,newPin);
                        updatePin.setInt(2,cid);
                        updatePin.executeUpdate();
                        System.out.println("PIN Updated.");
                    }

                    case 5 -> {
                        System.out.println("Thank You for Using ATM");
                        return;
                    }
                }
            }

        } catch (Exception e) { System.out.println(e); }
    }
}

