package bank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewEmployeesDialog {

    public static void showEmployees() {
        String[] colNames = {"ID", "Name", "Address", "Hire Date", "Salary"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);

        try {
            ResultSet rs = EmployeeDAO.getAllEmployees();
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("hire_date"),
                        rs.getDouble("salary")
                });
            }
        } catch (Exception e) { System.out.println(e); }

        JTable table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, pane, "Employee List", JOptionPane.INFORMATION_MESSAGE);
    }
}
