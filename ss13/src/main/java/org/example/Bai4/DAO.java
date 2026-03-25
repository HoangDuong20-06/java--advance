package org.example.Bai4;

import org.example.Bai4.Entity.Patiens;
import org.example.Bai4.Entity.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class DAO {

    public List<Patiens> getAllPatientsWithServices() {
        List<Patiens> result = new ArrayList<>();

        String sql = """
                SELECT p.patient_id, p.name,
                       s.service_id,
                       s.service_name
                FROM Patients p
                LEFT JOIN Services s 
                ON p.patient_id = s.patient_id
                """;

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            Map<Integer, Patiens> map = new LinkedHashMap<>();

            while (rs.next()) {
                int patientId = rs.getInt("patient_id");

                // Nếu chưa có bệnh nhân thì tạo mới
                Patiens patient = map.get(patientId);
                if (patient == null) {
                    patient = new Patiens(
                            patientId,
                            rs.getString("name")
                    );
                    map.put(patientId, patient);
                }

                // ===== XỬ LÝ BẪY 2 =====
                // Nếu không có service thì service_id sẽ NULL
                int serviceId = rs.getInt("service_id");
                if (!rs.wasNull()) {
                    Service service = new Service(
                            serviceId,
                            rs.getString("service_name")
                    );

                    patient.getDsDichVu().add(service);
                }
            }

            result = new ArrayList<>(map.values());

        } catch (Exception e) {
            System.out.println("Error while fetching data!");
            e.printStackTrace();
        }

        return result;
    }
}