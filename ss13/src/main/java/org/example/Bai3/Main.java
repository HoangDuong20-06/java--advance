package org.example.Bai3;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.dischargeAndProcessPayment(1, 2000);
        service.dischargeAndProcessPayment(2, 5000);
        service.dischargeAndProcessPayment(999, 1000);
    }
}
