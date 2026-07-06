package bank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewCustomersDialog {

    public static void showCustomers() {

        String[] colNames = {"ID", "Name", "Address", "City"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);

        try {
            ResultSet rs = CustomerDAO.getAllCustomers();
            while (rs.next()) {
    model.addRow(new Object[]{
            rs.getInt("cust_id"),
            rs.getString("name"),
            rs.getString("address"),   // Added
            rs.getString("city"),
            rs.getString("phone")
    });
}

        } catch (Exception e) { System.out.println(e); }

        JTable table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, pane, "Customer List", JOptionPane.INFORMATION_MESSAGE);
    }
}
