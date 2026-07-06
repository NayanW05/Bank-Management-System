package bank;
import java.sql.*;
import java.util.*;
import bank.MainApp;

public class Login {

    public static String login() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== LOGIN ===");
        System.out.print("Username: ");
        String user = MainApp.sc.nextLine();

        System.out.print("Password: ");
        String pass = MainApp.sc.nextLine();

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT role FROM users WHERE username=? AND password=?");
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Login Successful as: " + rs.getString("role"));
                return rs.getString("role");
            } else {
                System.out.println("Incorrect Login. Try again.");
                return login();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}

