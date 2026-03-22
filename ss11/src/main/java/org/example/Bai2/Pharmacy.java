package org.example.Bai2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Pharmacy {

    public void getAllMedicines() {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            System.out.println("=== Pharmacy List ===");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pharmacy");

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;

                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");

                System.out.println("Medicine name: " + name + " | Stock: " + stock);
            }

            if (!hasData) {
                System.out.println("The medicine warehouse is empty!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
