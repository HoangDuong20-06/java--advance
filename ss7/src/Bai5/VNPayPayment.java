package Bai5;

import java.text.DecimalFormat;

public class VNPayPayment implements PaymentMethod {
    DecimalFormat df = new DecimalFormat("#,###");
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán VNPay: " + df.format(amount));
    }
}
