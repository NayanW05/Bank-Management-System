package bank;

import javax.swing.*;

public class DeleteEmployeeDialog {

    public static void showForm() {
        JTextField id = new JTextField();

        Object[] form = {"Employee ID:", id};

        int result = JOptionPane.showConfirmDialog(null, form, 
                "Delete Employee", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                EmployeeDAO.deleteEmployee(Integer.parseInt(id.getText()));
                JOptionPane.showMessageDialog(null, "Employee Deleted!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
}

