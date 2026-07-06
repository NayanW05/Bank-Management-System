package bank;

import javax.swing.*;

public class AddCustomerDialog {

    public static void showForm() {
        JTextField name = new JTextField();
        JTextField addr = new JTextField();
        JTextField city = new JTextField();
        JTextField email = new JTextField();
        JTextField phone = new JTextField();
        JTextField bid = new JTextField();

        Object[] form = {
            "Name:", name,
            "Address:", addr,
            "City:", city,
            "Email:", email,
            "Phone:", phone,
            "Branch ID:", bid
        };

        int result = JOptionPane.showConfirmDialog(null, form, 
            "Add Customer", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                // Call your existing DAO insert
                CustomerDAO.addCustomer(name.getText(), addr.getText(), city.getText(),
                        email.getText(), phone.getText(), Integer.parseInt(bid.getText()));

                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }
}
