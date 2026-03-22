package org.example.Bai5;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DoctorDAO {
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Doctor d = new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialty")
                );
                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void addDoctor(Doctor doctor) {
//        String sql = "INSERT INTO doctors(id, name, specialty) VALUES (?, ?, ?)";
//        try (Connection conn = DBContext.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setInt(1, doctor.getId());
//            ps.setString(2, doctor.getName());
//            ps.setString(3, doctor.getSpecialty());
//            ps.executeUpdate();
//            System.out.println("Success Add!");
//        } catch (SQLIntegrityConstraintViolationException e) {
//            System.out.println("Same id doctor!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public void statisticBySpecialty() {
        String sql = "SELECT specialty, COUNT(*) AS total FROM doctors GROUP BY specialty";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("specialty") + " - " + rs.getInt("total"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}