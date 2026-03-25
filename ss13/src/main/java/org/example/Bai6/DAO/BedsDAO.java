package org.example.Bai6.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BedsDAO {
    public void freeBed(Connection conn, int patientId) throws Exception {
        String sql = "UPDATE beds SET status = 'Empty', patient_id = NULL WHERE patient_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, patientId);
        ps.executeUpdate();
    }
}
