package bank;

import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {

    public MainUI() {

        setTitle("Bank Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create tab container
        JTabbedPane tabs = new JTabbedPane();

        tabs.add("Customers", new CustomerPanel());
        tabs.add("Employees", new EmployeePanel());

        add(tabs, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new MainUI().setVisible(true);
    }
}
