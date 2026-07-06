package bank;

import javax.swing.*;

public class UpdateEmployeeDialog {

    public static void showForm() {
        JTextField id = new JTextField();
        JTextField salary = new JTextField();

        Object[] form = {
            "Employee ID:", id,
            "New Salary:", salary
        };

        int result = JOptionPane.showConfirmDialog(null, form, 
                "Update Employee Salary", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                EmployeeDAO.updateSalary(Integer.parseInt(id.getText()), Double.parseDouble(salary.getText()));
                JOptionPane.showMessageDialog(null, "Salary Updated!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
}
