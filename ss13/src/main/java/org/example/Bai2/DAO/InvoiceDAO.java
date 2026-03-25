package org.example.Bai2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InvoiceDAO {
    public int updateInvoiceStatus(Connection conn, int patientId) throws Exception {
        String sql = "UPDATE Invoices SET status = 'PAID' WHERE patient_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, patientId);

        return ps.executeUpdate();
    }
}
