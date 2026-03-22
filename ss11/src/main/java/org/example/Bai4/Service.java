package org.example.Bai4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Service {
    public void searchUnsafe(Connection conn, String name) {
        try {
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM Patients WHERE full_name = '" + name + "'";

            System.out.println("SQL: " + sql);

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("full_name"));
                System.out.println("------------------");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void searchPatientSafe(Connection conn, String patientName) {

        String sql = "SELECT * FROM Patients WHERE full_name = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, patientName);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("full_name"));
                System.out.println("------------------");
            }

            if (!found) {
                System.out.println("Not found patient!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
