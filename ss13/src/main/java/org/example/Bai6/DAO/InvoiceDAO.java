package org.example.Bai6.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InvoiceDAO {
    public void createInvoice(Connection conn, int patientId, double amount) throws Exception {
        String sql = "INSERT INTO invoices(patient_id, amount) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, patientId);
        ps.setDouble(2, amount);

        ps.executeUpdate();
    }
}
