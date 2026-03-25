package org.example.Bai6;

import org.example.Bai6.DAO.BedsDAO;
import org.example.Bai6.DAO.InvoiceDAO;
import org.example.Bai6.DAO.PatiensDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Service {
    private InvoiceDAO invoiceDAO = new InvoiceDAO();
    private PatiensDAO patientDAO = new PatiensDAO();
    private BedsDAO bedDAO = new BedsDAO();

    public void discharge(int patientId) {
        Connection conn = null;
        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);
            invoiceDAO.createInvoice(conn, patientId, 500.0);
            patientDAO.updateStatus(conn, patientId, "Discharged from hospital");
            bedDAO.freeBed(conn, patientId);
            conn.commit();
            System.out.println("Success");
        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
                System.out.println("Error");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void printData() {
        try (Connection conn = DBContext.getConnection();
             Statement st = conn.createStatement()) {
            System.out.println("\n--- Patients ---");
            ResultSet rs1 = st.executeQuery("SELECT * FROM patients");
            while (rs1.next()) {
                System.out.println(rs1.getInt("id") + " | " +
                        rs1.getString("name") + " | " +
                        rs1.getString("status"));
            }
            System.out.println("\n--- Beds ---");
            ResultSet rs2 = st.executeQuery("SELECT * FROM beds");
            while (rs2.next()) {
                System.out.println(rs2.getInt("id") + " | " +
                        rs2.getInt("patient_id") + " | " +
                        rs2.getString("status"));
            }
            System.out.println("\n--- Invoices ---");
            ResultSet rs3 = st.executeQuery("SELECT * FROM invoices");
            while (rs3.next()) {
                System.out.println(rs3.getInt("id") + " | " +
                        rs3.getInt("patient_id") + " | " +
                        rs3.getDouble("amount"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
