package Bai6;

import java.text.DecimalFormat;

public class POSPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Thanh toán tiền mặt tại POS: " + df.format(amount));
    }
}
