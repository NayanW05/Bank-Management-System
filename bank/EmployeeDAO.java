package bank;
import java.sql.*;
import java.util.*;
import bank.MainApp;

public class EmployeeDAO {

    public static void employeeMenu() {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n--- EMPLOYEE MANAGEMENT ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Back");
            System.out.print("Choice: ");

            switch(sc.nextInt()) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> updateSalary();
                case 4 -> deleteEmployee();
                case 5 -> { return; }
            }
        }
    }

public static void addEmployee() {
    try (Connection con = DBConnection.getConnection()) {

        System.out.print("Name: ");
        String name = MainApp.sc.nextLine();

        System.out.print("Address: ");
        String address = MainApp.sc.nextLine();

        System.out.print("Salary: ");
        double salary = MainApp.sc.nextDouble();

        System.out.print("Branch ID: ");
        int branch = MainApp.sc.nextInt();

        System.out.print("Role ID: ");
        int role = MainApp.sc.nextInt();
        MainApp.sc.nextLine(); // clear newline

        PreparedStatement ps = con.prepareStatement(
           "INSERT INTO employee(name,address,salary,branch_id,role_id,hire_date) VALUES(?,?,?,?,?,CURDATE())"
        );
        ps.setString(1, name);
        ps.setString(2, address);
        ps.setDouble(3, salary);
        ps.setInt(4, branch);
        ps.setInt(5, role);
        ps.executeUpdate();

        System.out.println("Employee Added Successfully!");

    } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
}


    public static void viewEmployees() {
    try (Connection con = DBConnection.getConnection()) {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT emp_id, name, address, salary, branch_id, role_id FROM employee");

        System.out.println("\nID | Name | Address | Salary | Branch | Role");
        System.out.println("---------------------------------------------------------");
        while (rs.next()) {
            System.out.println(
              rs.getInt(1) + " | " +
              rs.getString(2) + " | " +
              rs.getString(3) + " | " +
              rs.getDouble(4) + " | " +
              rs.getInt(5) + " | " +
              rs.getInt(6));
        }
    } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
}


    public static void updateSalary() {
    try (Connection con = DBConnection.getConnection()) {

        System.out.print("Employee ID: ");
        int id = MainApp.sc.nextInt();

        System.out.print("New Salary: ");
        double sal = MainApp.sc.nextDouble();
        MainApp.sc.nextLine();

        PreparedStatement ps = con.prepareStatement("UPDATE employee SET salary=? WHERE emp_id=?");
        ps.setDouble(1, sal);
        ps.setInt(2, id);

        if (ps.executeUpdate() > 0)
            System.out.println("Salary Updated!");
        else
            System.out.println("Employee Not Found!");

    } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
}


    public static void deleteEmployee() {
    try (Connection con = DBConnection.getConnection()) {

        System.out.print("Employee ID: ");
        int id = MainApp.sc.nextInt();
        MainApp.sc.nextLine();

        PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE emp_id=?");
        ps.setInt(1, id);

        if (ps.executeUpdate() > 0)
            System.out.println("Employee Deleted!");
        else
            System.out.println("Employee Not Found!");

    } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
}

public static ResultSet getAllEmployees() {
    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT emp_id, name, address, hire_date, salary FROM employee"
        );
        return ps.executeQuery();
    } catch (Exception e) { System.out.println(e); return null; }
}

public static void addEmployee(String name, String address, String hireDate, double salary, int branchId, int roleId) {
    try (Connection con = DBConnection.getConnection()) {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO employee(name,address,hire_date,salary,branch_id,role_id) VALUES(?,?,?,?,?,?)");
        ps.setString(1, name);
        ps.setString(2, address);
        ps.setString(3, hireDate);
        ps.setDouble(4, salary);
        ps.setInt(5, branchId);
        ps.setInt(6, roleId);
        ps.executeUpdate();
    } catch (Exception e) { System.out.println(e); }
}

public static void updateSalary(int id, double newSalary) {
    try (Connection con = DBConnection.getConnection()) {
        PreparedStatement ps = con.prepareStatement("UPDATE employee SET salary=? WHERE emp_id=?");
        ps.setDouble(1, newSalary);
        ps.setInt(2, id);
        ps.executeUpdate();
    } catch (Exception e) { System.out.println(e); }
}

public static void deleteEmployee(int id) {
    try (Connection con = DBConnection.getConnection()) {
        PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE emp_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (Exception e) { System.out.println(e); }
}


}
