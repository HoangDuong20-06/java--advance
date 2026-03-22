package org.example.Bai5;
import java.util.List;
public class DoctorService {
    private DoctorDAO dao = new DoctorDAO();
    public void showDoctors() {
        List<Doctor> list = dao.getAllDoctors();
        for (Doctor d : list) {
            System.out.println(d.getId() + " | " + d.getName() + " | " + d.getSpecialty());
        }
    }
    public void addDoctor(Doctor doctor) {
        dao.addDoctor(doctor);
    }
    public void statistic() {
        dao.statisticBySpecialty();
    }
}
