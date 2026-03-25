package org.example.Bai3;

import org.example.Bai3.Entity.Patiens;

import java.sql.Connection;

public class Service {
    public static void dischargeAndProcessPayment(int patientId, double hospitalFee) {
        Connection conn = null;
        DAO dao = new DAO();
        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);
            Patiens patient = dao.getPatientById(conn, patientId);
            if (patient == null) {
                throw new Exception("Patient not found!");
            }
            if (patient.getBalance() < hospitalFee) {
                throw new Exception("Insufficient balance!");
            }
            int row1 = dao.deductBalance(conn, patientId, hospitalFee);
            int row2 = dao.freeBed(conn, patientId);
            if (row2 == 0) {
                throw new Exception("No bed found to release!");
            }
            int row3 = dao.dischargePatient(conn, patientId);
            if (row3 == 0) {
                throw new Exception("Failed to update patient status!");
            }
            conn.commit();
            System.out.println("Discharge and payment successful!");
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
