package org.example.Bai3;

import org.example.Bai3.Entity.Patiens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    public Patiens getPatientById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM Patients WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Patiens(
                    rs.getInt("id"),
                    rs.getDouble("balance"),
                    rs.getString("status")
            );
        }
        return null;
    }
    public int deductBalance(Connection conn, int patientId, double amount) throws SQLException {
        String sql = "UPDATE Patients SET balance = balance - ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, amount);
        ps.setInt(2, patientId);

        return ps.executeUpdate();
    }
    public int freeBed(Connection conn, int patientId) throws SQLException {
        String sql = "UPDATE Beds SET status = 'AVAILABLE', patient_id = NULL WHERE patient_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, patientId);

        return ps.executeUpdate();
    }
    public int dischargePatient(Connection conn, int patientId) throws SQLException {
        String sql = "UPDATE Patients SET status = 'DISCHARGED' WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, patientId);
        return ps.executeUpdate();
    }
}
