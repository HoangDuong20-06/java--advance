package org.example.Bai3.Entity;

public class Patiens {
    private int id;
    private double balance;
    private String status;
    public Patiens() {}
    public Patiens(int id, double balance, String status) {
        this.id = id;
        this.balance = balance;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
