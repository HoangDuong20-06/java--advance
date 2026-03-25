package org.example.Bai1;

import java.sql.Connection;

public class Service {
    public static void dispenseMedicine(int patientId, int medicineId, int amount) {
        Connection conn = null;
        DAO dao = new DAO();

        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);
            int currentQty = dao.getMedicineQuantity(conn, medicineId);

            if (currentQty == -1) {
                throw new Exception("Medicine not found!");
            }
            if (currentQty < amount) {
                throw new Exception("Not enough medicine in stock!");
            }
            int row1 = dao.deductMedicine(conn, medicineId, amount);
            if (row1 == 0) {
                throw new Exception("Failed to deduct medicine!");
            }
            int row2 = dao.insertPrescription(conn, patientId, medicineId, amount);
            if (row2 == 0) {
                throw new Exception("Failed to insert prescription!");
            }
            conn.commit();
            System.out.println("Dispense medicine successfully!");
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("Transaction failed: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
