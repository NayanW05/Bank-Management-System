package bank;

import javax.swing.*;
import java.awt.*;

public class CustomerPanel extends JPanel {

    public CustomerPanel() {
        setLayout(new GridLayout(5,1,10,10));

        JButton addBtn = new JButton("Add Customer");
        JButton viewBtn = new JButton("View Customers");
        JButton updateBtn = new JButton("Update Customer");
        JButton deleteBtn = new JButton("Delete Customer");

        add(addBtn);
        add(viewBtn);
        add(updateBtn);
        add(deleteBtn);

        //Correct Swing UI Calls
        addBtn.addActionListener(e -> AddCustomerDialog.showForm());
        viewBtn.addActionListener(e -> ViewCustomersDialog.showCustomers());
        updateBtn.addActionListener(e -> UpdateCustomerDialog.showForm());
        deleteBtn.addActionListener(e -> DeleteCustomerDialog.showForm());
    }
}
