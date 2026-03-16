package Bai5;

import java.text.DecimalFormat;

public class GenericPaymentMethod implements PaymentMethod {

    private String name;
    public GenericPaymentMethod(String name) {
        this.name = name;
    }
    @Override
    public void pay(double amount) {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Thanh toán bằng " + name + ": " + df.format(amount));

    }
    public String getName() {
        return name;
    }
}
