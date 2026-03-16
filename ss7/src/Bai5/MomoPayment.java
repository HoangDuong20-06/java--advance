package Bai5;

import java.text.DecimalFormat;

public class MomoPayment implements PaymentMethod {
    DecimalFormat df = new DecimalFormat("#,###");
    public void pay(double amount) {
        System.out.println("Thanh toán Momo: " + df.format(amount));
    }
}
