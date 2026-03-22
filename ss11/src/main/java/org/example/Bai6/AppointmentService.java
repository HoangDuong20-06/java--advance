package org.example.Bai6;

import java.util.List;
public class AppointmentService {
    private AppointmentDAO dao = new AppointmentDAO();

    public void add(Appointment a) {
        dao.add(a);
    }
    public void showAll() {
        List<Appointment> list = dao.getAll();
        for (Appointment a : list) {
            System.out.println(a.getId() + " | " + a.getPatientName() + " | " + a.getAppointmentDate());
        }
    }
    public void delete(int id) {
        dao.delete(id);
    }
}