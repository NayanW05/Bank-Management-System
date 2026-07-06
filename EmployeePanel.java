package bank;

import javax.swing.*;
import java.awt.*;

public class EmployeePanel extends JPanel {

    public EmployeePanel() {
        setLayout(new GridLayout(5,1,10,10));

        JButton addBtn = new JButton("Add Employee");
        JButton viewBtn = new JButton("View Employees");
        JButton updateBtn = new JButton("Update Salary");
        JButton deleteBtn = new JButton("Delete Employee");

        add(addBtn);
        add(viewBtn);
        add(updateBtn);
        add(deleteBtn);

        addBtn.addActionListener(e -> AddEmployeeDialog.showForm());
        viewBtn.addActionListener(e -> ViewEmployeesDialog.showEmployees());
        updateBtn.addActionListener(e -> UpdateEmployeeDialog.showForm());
        deleteBtn.addActionListener(e -> DeleteEmployeeDialog.showForm());
    }
}
/*package bank;

import javax.swing.*;
import java.awt.*;

public class EmployeePanel extends JPanel {

    public EmployeePanel() {
        setLayout(new GridLayout(4,1,10,10));

        JButton addBtn = new JButton("Add Employee");
        JButton viewBtn = new JButton("View Employees");
        JButton updateBtn = new JButton("Update Salary");
        JButton deleteBtn = new JButton("Delete Employee");

        add(addBtn);
        add(viewBtn);
        add(updateBtn);
        add(deleteBtn);

        addBtn.addActionListener(e -> EmployeeDAO.addEmployee());
        viewBtn.addActionListener(e -> EmployeeDAO.viewEmployees());
        updateBtn.addActionListener(e -> EmployeeDAO.updateSalary());
        deleteBtn.addActionListener(e -> EmployeeDAO.deleteEmployee());
    }
}*/
