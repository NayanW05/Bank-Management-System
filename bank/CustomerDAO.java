package bank;
import java.sql.*;
import java.util.*;
import bank.MainApp;

public class CustomerDAO {

    public static void customerMenu() {
       // Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- CUSTOMER MANAGEMENT ---");
            System.out.println("1. Add New Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back");
            System.out.print("Choice: ");

            int choice = MainApp.sc.nextInt();
MainApp.sc.nextLine(); // ← CLEAR BUFFER

switch (choice) {

                case 1 -> addCustomer();
                case 2 -> viewCustomers();
                case 3 -> updateCustomer();
                case 4 -> deleteCustomer();
                case 5 -> { return; }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    // ADD CUSTOMER
   /*ublic static void addCustomer() {
        try (Connection con = DBConnection.getConnection();
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Name: "); String name = MainApp.sc.nextLine();
            System.out.print("Address: "); String addr = MainApp.sc.nextLine();
            System.out.print("City: "); String city = MainApp.sc.nextLine();
            System.out.print("Email: "); String email = MainApp.sc.nextLine();
            System.out.print("Phone: "); String phone = MainApp.sc.nextLine();
            System.out.print("Branch ID: "); int bid = MainApp.sc.nextInt();

            PreparedStatement ps = con.prepareStatement(
               "INSERT INTO customer(name,address,city,email,phone,DOB,branch_id) VALUES(?,?,?,?,?,CURDATE(),?)");
            ps.setString(1,name);
            ps.setString(2,addr);
            ps.setString(3,city);
            ps.setString(4,email);
            ps.setString(5,phone);
            ps.setInt(6,bid);
            ps.executeUpdate();

            System.out.println("✅ Customer Added Successfully");
        } catch (Exception e) { System.out.println(e); }
    }*/

    /*public static void addCustomer() {
    try (Connection con = DBConnection.getConnection()) {

        System.out.print("Name: ");
        String name = MainApp.sc.nextLine();

        System.out.print("Address: ");
        String addr = MainApp.sc.nextLine();

        System.out.print("City: ");
        String city = MainApp.sc.nextLine();

        System.out.print("Email: ");
        String email = MainApp.sc.nextLine();

        System.out.print("Phone: ");
        String phone = MainApp.sc.nextLine();

        System.out.print("Branch ID: ");
        int bid = MainApp.sc.nextInt();
        MainApp.sc.nextLine();  // ✅ clear leftover newline

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO customer(name, address, city, email, phone, DOB, branch_id) VALUES (?, ?, ?, ?, ?, CURDATE(), ?)"
        );

        ps.setString(1, name);
        ps.setString(2, addr);
        ps.setString(3, city);
        ps.setString(4, email);
        ps.setString(5, phone);
        ps.setInt(6, bid);

        ps.executeUpdate();

        System.out.println("✅ Customer Added Successfully!");

    } catch (Exception e) {
        System.out.println("❌ Error: " + e.getMessage());
    }
}*/

public static void addCustomer() {
    System.out.print("Name: "); String name = MainApp.sc.nextLine();
    System.out.print("Address: "); String addr = MainApp.sc.nextLine();
    System.out.print("City: "); String city = MainApp.sc.nextLine();
    System.out.print("Email: "); String email = MainApp.sc.nextLine();
    System.out.print("Phone: "); String phone = MainApp.sc.nextLine();
    System.out.print("Branch ID: "); int bid = MainApp.sc.nextInt();
    MainApp.sc.nextLine(); // clear newline

    addCustomer(name, addr, city, email, phone, bid);
    System.out.println("✅ Customer Added Successfully!");
}

public static void addCustomer(String name, String addr, String city, String email, String phone, int bid) {
    try (Connection con = DBConnection.getConnection()) {
        PreparedStatement ps = con.prepareStatement(
           "INSERT INTO customer(name,address,city,email,phone,DOB,branch_id) VALUES(?,?,?,?,?,CURDATE(),?)");

        ps.setString(1,name);
        ps.setString(2,addr);
        ps.setString(3,city);
        ps.setString(4,email);
        ps.setString(5,phone);
        ps.setInt(6,bid);

        ps.executeUpdate();
    } catch (Exception e) { System.out.println(e); }
}



    // VIEW CUSTOMERS
    public static void viewCustomers() {
    try (Connection con = DBConnection.getConnection()) {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT cust_id, name, address, city, phone FROM customer");

        System.out.println("\nID | Name | Address | City | Phone");
        System.out.println("---------------------------------------------------------");

        while (rs.next()) {
            System.out.println(
                rs.getInt(1) + " | " +
                rs.getString(2) + " | " +
                rs.getString(3) + " | " +
                rs.getString(4) + " | " +
                rs.getString(5)
            );
        }

    } catch (Exception e) {
        System.out.println("❌ Error: " + e.getMessage());
    }
}


    // UPDATE CUSTOMER
   /*ublic static void updateCustomer() {
        try (Connection con = DBConnection.getConnection();
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Customer ID to Update: ");
            int id = MainApp.sc.nextInt();
            MainApp.sc.nextLine();
            System.out.print("New Address: ");
            String addr = MainApp.sc.nextLine();

            PreparedStatement ps = con.prepareStatement("UPDATE customer SET address=? WHERE cust_id=?");
            ps.setString(1, addr);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("✅ Customer Updated.");

        } catch (Exception e) { System.out.println(e); }
    }
*/

public static void updateCustomer() {
    try (Connection con = DBConnection.getConnection()) {

        System.out.print("Enter Customer ID to Update: ");
        int id = MainApp.sc.nextInt();
        MainApp.sc.nextLine(); // ✅ clear newline buffer

        System.out.print("New Address: ");
        String addr = MainApp.sc.nextLine();

        PreparedStatement ps = con.prepareStatement(
            "UPDATE customer SET address = ? WHERE cust_id = ?"
        );
        ps.setString(1, addr);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("✅ Customer Updated Successfully!");
        else
            System.out.println("⚠️ No Customer Found With That ID.");

    } catch (Exception e) {
        System.out.println("❌ Error: " + e.getMessage());
    }
}

    // DELETE CUSTOMER
public static void deleteCustomer() {
    try (Connection con = DBConnection.getConnection()) {

        System.out.print("Enter Customer ID to Delete: ");
        int id = MainApp.sc.nextInt();
        MainApp.sc.nextLine(); // ✅ clear leftover newline

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM customer WHERE cust_id = ?"
        );
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("✅ Customer Deleted Successfully!");
        else
            System.out.println("⚠️ No Customer Found With That ID.");

    } catch (Exception e) {
        System.out.println("❌ Error: " + e.getMessage());
    }
}


// NEW: View all customers and return ResultSet for UI
public static ResultSet getAllCustomers() {
    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT cust_id, name, address, city, phone FROM customer"
        );
        return ps.executeQuery();
    } catch (Exception e) { 
        System.out.println(e); 
        return null; 
    }
}


// NEW: Update customer address using direct parameters
public static void updateCustomer(int id, String newAddress) {
    try (Connection con = DBConnection.getConnection()) {
        PreparedStatement ps = con.prepareStatement("UPDATE customer SET address=? WHERE cust_id=?");
        ps.setString(1, newAddress);
        ps.setInt(2, id);
        ps.executeUpdate();
    } catch (Exception e) { System.out.println(e); }
}

// NEW: Delete a customer by ID
public static void deleteCustomer(int id) {
    try (Connection con = DBConnection.getConnection()) {
        PreparedStatement ps = con.prepareStatement("DELETE FROM customer WHERE cust_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (Exception e) { System.out.println(e); }
}


}