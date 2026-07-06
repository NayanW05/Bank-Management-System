package bank;

import javax.swing.*;

public class DeleteCustomerDialog {

    public static void showForm() {
        JTextField id = new JTextField();

        Object[] form = {"Customer ID:", id};

        int result = JOptionPane.showConfirmDialog(null, form,
                "Delete Customer", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                CustomerDAO.deleteCustomer(Integer.parseInt(id.getText()));
                JOptionPane.showMessageDialog(null, "Customer Deleted Successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }
}
