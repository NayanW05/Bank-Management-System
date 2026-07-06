package bank;

import javax.swing.*;

public class AddEmployeeDialog {

    public static void showForm() {

        JTextField name = new JTextField();
        JTextField addr = new JTextField();
        JTextField hire = new JTextField("2025-01-01");
        JTextField salary = new JTextField();
        JTextField branch = new JTextField();
        JTextField role = new JTextField();

        Object[] form = {
            "Name:", name,
            "Address:", addr,
            "Hire Date (YYYY-MM-DD):", hire,
            "Salary:", salary,
            "Branch ID:", branch,
            "Role ID:", role
        };

        int result = JOptionPane.showConfirmDialog(null, form, 
                "Add Employee", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                EmployeeDAO.addEmployee(
                    name.getText(), 
                    addr.getText(), 
                    hire.getText(), 
                    Double.parseDouble(salary.getText()), 
                    Integer.parseInt(branch.getText()), 
                    Integer.parseInt(role.getText())
                );
                JOptionPane.showMessageDialog(null, "Employee Added Successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
}

