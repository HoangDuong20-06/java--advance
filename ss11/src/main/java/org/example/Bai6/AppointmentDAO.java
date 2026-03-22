package org.example.Bai6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    public void add(Appointment a) {
        String sql = "INSERT INTO appointments(patient_name, appointment_date, doctor_name, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.getPatientName());
            ps.setDate(2, a.getAppointmentDate());
            ps.setString(3, a.getDoctorName());
            ps.setString(4, a.getStatus());

            ps.executeUpdate();
            System.out.println("Success Add");

        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
    public List<Appointment> getAll() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Appointment a = new Appointment();
                a.setId(rs.getInt("id"));
                a.setPatientName(rs.getString("patient_name"));
                a.setAppointmentDate(rs.getDate("appointment_date"));
                a.setDoctorName(rs.getString("doctor_name"));
                a.setStatus(rs.getString("status"));
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void delete(int id) {
        String sql = "DELETE FROM appointments WHERE id = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Delete Success");
        } catch (Exception e) {
            System.out.println("Can't delete!");
        }
    }
    public Appointment getById(int id) {
        String sql = "SELECT * FROM appointments WHERE id = ?";
        Appointment a = null;
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a = new Appointment();
                a.setId(rs.getInt("id"));
                a.setPatientName(rs.getString("patient_name"));
                a.setAppointmentDate(rs.getDate("appointment_date"));
                a.setDoctorName(rs.getString("doctor_name"));
                a.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
    public void update(Appointment a) {
        String sql = "UPDATE appointments SET patient_name=?, appointment_date=?, doctor_name=?, status=? WHERE id=?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getPatientName());
            ps.setDate(2, a.getAppointmentDate());
            ps.setString(3, a.getDoctorName());
            ps.setString(4, a.getStatus());
            ps.setInt(5, a.getId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Update sucess");
            } else {
                System.out.println("Not found ID!");
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
}
