package org.example.Bai2.DAO;

import org.example.Bai2.Entity.PatientWallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WalletDAO {
    public PatientWallet getWalletByPatientId(Connection conn, int patientId) throws Exception {
        String sql = "SELECT * FROM Patient_Wallet WHERE patient_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, patientId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new PatientWallet(
                    rs.getInt("patient_id"),
                    rs.getDouble("balance")
            );
        }
        return null;
    }
    public int deductBalance(Connection conn, int patientId, double amount) throws Exception {
        String sql = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, amount);
        ps.setInt(2, patientId);

        return ps.executeUpdate();
    }
}
