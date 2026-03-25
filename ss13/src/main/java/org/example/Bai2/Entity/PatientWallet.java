package org.example.Bai2.Entity;

public class PatientWallet {
    private int patientId;
    private double balance;

    public PatientWallet(int patientId, double balance) {
        this.patientId = patientId;
        this.balance = balance;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
