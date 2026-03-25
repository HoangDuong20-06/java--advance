package org.example.Bai5.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BedsDAO {
    public boolean isBedAvailable(Connection conn, int bedId) throws Exception {
        String sql = "SELECT status FROM beds WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, bedId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("status").equals("Empty");
        }
        return false;
    }
    public void occupyBed(Connection conn, int bedId) throws Exception {
        String sql = "UPDATE beds SET status = 'have people' WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, bedId);
        ps.executeUpdate();
    }
}
