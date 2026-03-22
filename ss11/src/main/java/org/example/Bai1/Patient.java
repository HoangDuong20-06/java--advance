package org.example.Bai1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Patient {

    public void getAllPatients() {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("name") + " - " +
                                rs.getString("email")
                );
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