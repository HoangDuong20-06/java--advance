package org.example.Bai5.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatiensDAO {
    public int insertPatient(Connection conn, String name, int age) throws Exception {
        String sql = "INSERT INTO patients(name, age) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        throw new Exception("ID NOT FOUND");
    }
}
