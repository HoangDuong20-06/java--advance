package org.example.Bai5;

import org.example.Bai5.DAO.BedsDAO;
import org.example.Bai5.DAO.PatiensDAO;
import org.example.Bai5.DAO.PaymentDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Service {
    private PatiensDAO patientDAO = new PatiensDAO();
    private BedsDAO bedDAO = new BedsDAO();
    private PaymentDAO paymentDAO = new PaymentDAO();
    public void admitPatient(String name, int age, int bedId, double money) {
        Connection conn = null;
        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);
            if (!bedDAO.isBedAvailable(conn, bedId)) {
                throw new Exception("Bed have people!");
            }
            int patientId = patientDAO.insertPatient(conn, name, age);
            bedDAO.occupyBed(conn, bedId);
            paymentDAO.insertPayment(conn, patientId, money);
            conn.commit();
            System.out.println("Successfully received!");
        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
                System.out.println("Error: " + e.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void showEmptyBeds() {
        try (Connection conn = DBContext.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM beds WHERE status = 'Empty'")) {
            System.out.println("\n--- Empty bed ---");
            while (rs.next()) {
                System.out.println("Bed ID: " + rs.getInt("id"));
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
}
