package org.example.Bai6.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PatiensDAO {
    public void updateStatus(Connection conn, int patientId, String status) throws Exception {
        String sql = "UPDATE patients SET status = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, status);
        ps.setInt(2, patientId);

        ps.executeUpdate();
    }
}
