package org.example.Bai4;

import org.example.Bai4.Entity.Patiens;
import org.example.Bai4.Entity.Service;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Patiens> list = dao.getAllPatientsWithServices();
        for (Patiens bn : list) {
            System.out.println("\nPatiens: " + bn.getName());
            if (bn.getDsDichVu().isEmpty()) {
                System.out.println("  (Not have service)");
            } else {
                for (Service dv : bn.getDsDichVu()) {
                    System.out.println("  - " + dv.getName());
                }
            }
        }
    }
}
