package org.example.Bai3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BedService {
    public void updateBedStatus(Connection conn, int bedId) {
        String sql = "UPDATE Beds SET bed_status = ? WHERE bed_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Occupied");
            ps.setInt(2, bedId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Success update bed!");
            } else {
                System.out.println("Bed id not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
        }
    }
}
