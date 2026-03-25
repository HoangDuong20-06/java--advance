package org.example.Bai6.Entity;

public class Beds {
    private int id;
    private int patientId;
    private String status;
    public Beds() {}
    public Beds(int id, int patientId, String status) {
        this.id = id;
        this.patientId = patientId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
