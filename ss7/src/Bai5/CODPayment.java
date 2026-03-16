package Bai5;

import java.text.DecimalFormat;

public class CODPayment implements PaymentMethod {
    DecimalFormat df = new DecimalFormat("#,###");
    public void pay(double amount) {
        System.out.println("Thanh toán COD: " + df.format(amount));
    }
}
