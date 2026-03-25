package org.example.Bai2.Entity;

public class Invoice {
    private int invoiceId;
    private int patientId;
    private String status;

    public Invoice(int invoiceId, int patientId, String status) {
        this.invoiceId = invoiceId;
        this.patientId = patientId;
        this.status = status;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
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
