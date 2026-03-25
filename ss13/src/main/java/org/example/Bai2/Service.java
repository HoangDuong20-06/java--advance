package org.example.Bai2;

import org.example.Bai2.DAO.WalletDAO;
import org.example.Bai2.Entity.PatientWallet;
import org.example.Bai2.DAO.InvoiceDAO;

import java.sql.Connection;

public class Service {
    private WalletDAO walletDAO = new WalletDAO();
    private InvoiceDAO invoiceDAO = new InvoiceDAO();
    public void processPayment(int patientId, double amount) {
        Connection conn = null;
        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);
            PatientWallet wallet = walletDAO.getWalletByPatientId(conn, patientId);
            if (wallet == null) {
                throw new Exception("Patient wallet not found!");
            }
            if (wallet.getBalance() < amount) {
                throw new Exception("Insufficient balance!");
            }
            int row1 = walletDAO.deductBalance(conn, patientId, amount);
            if (row1 == 0) {
                throw new Exception("Failed to deduct balance!");
            }
            int row2 = invoiceDAO.updateInvoiceStatus(conn, patientId);
            if (row2 == 0) {
                throw new Exception("Failed to update invoice!");
            }
            conn.commit();
            System.out.println("Payment successful!");
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
