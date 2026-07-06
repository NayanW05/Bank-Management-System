package bank;

import javax.swing.*;

public class UpdateCustomerDialog {

    public static void showForm() {
        JTextField id = new JTextField();
        JTextField newAddr = new JTextField();

        Object[] form = {
            "Customer ID:", id,
            "New Address:", newAddr
        };

        int result = JOptionPane.showConfirmDialog(null, form, 
            "Update Customer Address", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                CustomerDAO.updateCustomer(Integer.parseInt(id.getText()), newAddr.getText());
                JOptionPane.showMessageDialog(null, "Customer Updated Successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }
}

