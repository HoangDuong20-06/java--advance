package org.example.Bai5.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDAO {
    public void insertPayment(Connection conn, int patientId, double amount) throws Exception {
        String sql = "INSERT INTO payments(patient_id, amount) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, patientId);
        ps.setDouble(2, amount);
        ps.executeUpdate();
    }
}
