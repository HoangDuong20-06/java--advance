package org.example.Bai1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    public int getMedicineQuantity(Connection conn, int medicineId) throws Exception {
        String sql = "SELECT quantity FROM Medicine_Inventory WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, medicineId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("quantity");
        }
        return -1;
    }
    public int deductMedicine(Connection conn, int medicineId, int amount) throws Exception {
        String sql = "UPDATE Medicine_Inventory SET quantity = quantity - ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, amount);
        ps.setInt(2, medicineId);

        return ps.executeUpdate();
    }
    public int insertPrescription(Connection conn, int patientId, int medicineId, int amount) throws Exception {
        String sql = "INSERT INTO Prescription_History(patient_id, medicine_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, patientId);
        ps.setInt(2, medicineId);
        ps.setInt(3, amount);

        return ps.executeUpdate();
    }
}
