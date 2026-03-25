package org.example.Bai6.Entity;

import java.sql.Timestamp;

public class Invoice {
    private int id;
    private int patientId;
    private double amount;
    private Timestamp createdAt;
    public Invoice() {}

    public Invoice(int id, int patientId, double amount, Timestamp createdAt) {
        this.id = id;
        this.patientId = patientId;
        this.amount = amount;
        this.createdAt = createdAt;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
